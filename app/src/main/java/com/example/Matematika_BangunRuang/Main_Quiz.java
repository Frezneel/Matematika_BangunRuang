package com.example.Matematika_BangunRuang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Main_Quiz extends AppCompatActivity {
    public static final String EXTRA_SCORE = "extrascore";
    private static final long COUNTDOWN_IN_MILLIS = 30000;

    private static final String KEY_SCORE = "keyScore";
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_MILLIS_LEFT = "keyMillisLeft";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_QUESTION_LIST = "keyQuestionList";

    private TextView view_soal, view_nilai, view_banyaksoal, view_waktu;
    private RadioGroup pilihan;
    private RadioButton pilihan1,pilihan2, pilihan3, pilihan4;
    private Button konfirm;

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private ArrayList<Soal> soals;
    private int soalCounter;
    private int soalCountTotal;
    private Soal currentSoal;

    private int nilai;
    private boolean terjawab;

    private long backPressedTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz);
        view_soal= findViewById(R.id.pertanyaan);
        view_nilai= findViewById(R.id.view_score);
        view_banyaksoal= findViewById(R.id.view_pertanyaan);
        view_waktu= findViewById(R.id.waktu);
        pilihan= findViewById(R.id.rg_jawaban);
        pilihan1= findViewById(R.id.rb_pilihan1);
        pilihan2= findViewById(R.id.rb_pilihan2);
        pilihan3= findViewById(R.id.rb_pilihan3);
        pilihan4= findViewById(R.id.rb_pilihan4);
        konfirm= findViewById(R.id.submit_quiz);

        textColorDefaultRb = pilihan1.getTextColors();
        textColorDefaultCd = view_waktu.getTextColors();

        if (savedInstanceState == null){
            QuizDbHelper dbHelper = new QuizDbHelper(this);
            soals = dbHelper.getAllQuestion();
            soalCountTotal = soals.size();
            Collections.shuffle(soals);

            showNextSoal();
        }else {
            soals = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);
            if(soals == null){
                finish();
            }
            soalCountTotal = soals.size();
            soalCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT);
            currentSoal = soals.get(soalCounter - 1);
            nilai = savedInstanceState.getInt(KEY_SCORE);
            timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT);
            terjawab = savedInstanceState.getBoolean(KEY_ANSWERED);

            if(!terjawab){
                startCountDown();
            }else {
                updateCountDownText();
                tampilSolusi();
            }

        }

        konfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!terjawab){
                    if (pilihan1.isChecked() || pilihan2.isChecked() || pilihan3.isChecked() || pilihan4.isChecked()){
                        checkJawaban();
                    }else {
                        Toast.makeText(Main_Quiz.this, "Tolong Pilih Jawabannya", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    showNextSoal();
                }
            }
        });
    }

    private void showNextSoal(){
        pilihan1.setTextColor(textColorDefaultRb);
        pilihan2.setTextColor(textColorDefaultRb);
        pilihan3.setTextColor(textColorDefaultRb);
        pilihan4.setTextColor(textColorDefaultRb);
        pilihan.clearCheck();

        if (soalCounter < soalCountTotal){
            currentSoal = soals.get(soalCounter);

            view_soal.setText(currentSoal.getSoal());
            pilihan1.setText(currentSoal.getPilihan1());
            pilihan2.setText(currentSoal.getPilihan2());
            pilihan3.setText(currentSoal.getPilihan3());
            pilihan4.setText(currentSoal.getPilihan4());

            soalCounter++;
            view_banyaksoal.setText("Soal Ke- "+ soalCounter + " / " + soalCountTotal);
            terjawab = false;
            konfirm.setText("Konfirm");

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        }
        else {
            finishQuiz();
        }

    }

    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                checkJawaban();
            }
        }.start();
    }

    private void updateCountDownText(){
        int minutes =(int) (timeLeftInMillis / 1000) / 60;
        int second = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, second);

        view_waktu.setText(timeFormatted);

        if (timeLeftInMillis < 10000){
            view_waktu.setTextColor(Color.RED);
        }else{
            view_waktu.setTextColor(textColorDefaultCd);
        }
    }

    private void checkJawaban(){
        terjawab = true;

        countDownTimer.cancel();

        RadioButton rbTerpilih = findViewById(pilihan.getCheckedRadioButtonId());
        int jawabNr = pilihan.indexOfChild(rbTerpilih) + 1;

        if (jawabNr == currentSoal.getJawaban()){
            nilai++;
            view_nilai.setText("Nilai = "+nilai);
        }

        tampilSolusi();

    }

    private void tampilSolusi(){
        pilihan1.setTextColor(Color.RED);
        pilihan2.setTextColor(Color.RED);
        pilihan3.setTextColor(Color.RED);
        pilihan4.setTextColor(Color.RED);

        switch (currentSoal.getJawaban()){
            case 1:
                pilihan1.setTextColor(Color.GREEN);
                view_soal.setText("A Jawaban yang Benar");
                break;
            case 2:
                pilihan2.setTextColor(Color.GREEN);
                view_soal.setText("B Jawaban yang Benar");
                break;
            case 3:
                pilihan3.setTextColor(Color.GREEN);
                view_soal.setText("C Jawaban yang Benar");
                break;
            case 4:
                pilihan4.setTextColor(Color.GREEN);
                view_soal.setText("D Jawaban yang Benar");
                break;

        }
        if (soalCounter<soalCountTotal){
            konfirm.setBackgroundColor(Color.GREEN);
            konfirm.setText("Selanjutnya");
        }else {
            konfirm.setText("Selesai");
        }
    }

    private void finishQuiz(){
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, nilai);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishQuiz();
        } else
        {
            Toast.makeText(this, "Tekan back lagi untuk selesai", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null){
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE, nilai);
        outState.putInt(KEY_QUESTION_COUNT, soalCounter);
        outState.putLong(KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED, terjawab);
        outState.putParcelableArrayList(KEY_QUESTION_LIST, soals);
    }
}