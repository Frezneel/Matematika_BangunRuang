package com.example.Matematika_BangunRuang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class balok_menu extends AppCompatActivity {
    private EditText et_panjangbalok, et_lebarbalok, et_tinggibalok;
    private RadioGroup RG_balok;
    private RadioButton rb_volumebalok, rb_luaspermukaan;
    private Button bt_hitungbalok, bt_resetbalok, bt_backbalok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balok_menu);
        et_panjangbalok= findViewById(R.id.et_panjangbalok);
        et_lebarbalok= findViewById(R.id.et_lebarbalok);
        et_tinggibalok= findViewById(R.id.et_tinggibalok);
        RG_balok= findViewById(R.id.RG_balok);
        rb_volumebalok= findViewById(R.id.rb_volumebalok);
        rb_luaspermukaan= findViewById(R.id.rb_luaspermukaan);
        bt_backbalok= findViewById(R.id.bt_backbalok);
        bt_hitungbalok= findViewById(R.id.bt_hitungbalok);
        bt_resetbalok= findViewById(R.id.bt_resetbalok);

    }

    public void handleHitungBalok(View view) {
        Intent hitungbalok = new Intent(this, tampilbalok.class);
        if(et_panjangbalok.getText().toString().length()==0){
            et_panjangbalok.setError("Harap Diisi!");}
        else{
            if(et_lebarbalok.getText().toString().length()==0){
                et_lebarbalok.setError("Harap Diisi!");}
            else{
                if(et_tinggibalok.getText().toString().length()==0)
                {
                    et_tinggibalok.setError("Harap Diisi!");
                }
                else {
                    double P = Double.parseDouble(et_panjangbalok.getText().toString());
                    hitungbalok.putExtra("et_panjangbalok", P);
                    double L = Double.parseDouble(et_lebarbalok.getText().toString());
                    hitungbalok.putExtra("et_lebarbalok", L);
                    double T = Double.parseDouble(et_tinggibalok.getText().toString());
                    hitungbalok.putExtra("et_tinggibalok", T);
                    int selectedID = RG_balok.getCheckedRadioButtonId();
                    if (selectedID == -1) {
                        Toast.makeText(this, "Tidak ada yang dipilih!", Toast.LENGTH_SHORT).show();
                    } else {
                        RadioButton RG_balok_view = RG_balok.findViewById(selectedID);
                        hitungbalok.putExtra("RG_balok", RG_balok_view.getText());
                        Toast.makeText(this, "Pilihan Anda Adalah " + RG_balok_view.getText(), Toast.LENGTH_SHORT).show();
                        startActivity(hitungbalok);
                    }
                }
            }
        }
    }

    public void handleResetBalok(View view) {
        et_panjangbalok.getText().clear();
        et_lebarbalok.getText().clear();
        et_tinggibalok.getText().clear();
        RG_balok.clearCheck();
    }

    public void handleBackBalok(View view) {
        Intent backbalok = new Intent(this, Menghitung_Menu.class);
        finish();
    }
}