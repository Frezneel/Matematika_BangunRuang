package com.example.Matematika_BangunRuang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Quiz_menu extends AppCompatActivity {
    private Button mulai_quiz;
    private static final int REQUEST_CODE_QUIZ = 1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView view_highscore;

    private int highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);
        view_highscore = findViewById(R.id.nilai_tertinggi);
        loadHighScore();

        mulai_quiz = findViewById(R.id.bt_mulai_quiz);

        mulai_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startquiz();
            }
        });
    }

    private void startquiz(){
        Intent intent = new Intent(Quiz_menu.this, Main_Quiz.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_QUIZ){
            if(resultCode == RESULT_OK){
                int score = data.getIntExtra(Main_Quiz.EXTRA_SCORE, 0);
                if (score> highscore){
                    updateHighscore(score);
                }
            }

        }
    }
    private void loadHighScore(){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE,0);
        view_highscore.setText("Nilai Tertinggi = " + highscore);

    }

    private void updateHighscore(int highscorenew){
        highscore= highscorenew;
        view_highscore.setText("Nilai Tertinggi = " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
}