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

public class bola_menu extends AppCompatActivity {
    private EditText et_jaribola;
    private RadioGroup RG_bola;
    private RadioButton rb_volumebola, rb_luaspermukaanbola;
    private Button bt_hitungbola, bt_resetbola, bt_backbola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bola_menu);
        et_jaribola= findViewById(R.id.et_jaribola);
        RG_bola= findViewById(R.id.RG_bola);
        rb_volumebola= findViewById(R.id.rb_volumebola);
        rb_luaspermukaanbola= findViewById(R.id.rb_luaspermukaanbola);
        bt_backbola= findViewById(R.id.bt_backbola);
        bt_hitungbola= findViewById(R.id.bt_hitungbola);
        bt_resetbola= findViewById(R.id.bt_resetbola);
    }

    public void handleHitungbola(View view) {
        Intent hitungbola = new Intent(this, tampilbola.class);
        if(et_jaribola.getText().toString().length()==0){
            et_jaribola.setError("Harap Diisi!");}
        else{
            double r=Double.parseDouble(et_jaribola.getText().toString());    hitungbola.putExtra("et_jaribola", r);
            int selectedID = RG_bola.getCheckedRadioButtonId();
            if (selectedID == -1) {
                Toast.makeText(this, "Tidak ada yang dipilih!",Toast.LENGTH_SHORT).show();
            }
            else{
                RadioButton RG_bola_view = RG_bola.findViewById(selectedID);
                hitungbola.putExtra("RG_bola",RG_bola_view.getText());
                Toast.makeText(this, "Pilihan Anda Adalah "+ RG_bola_view.getText(), Toast.LENGTH_SHORT).show();
                startActivity(hitungbola);
            }
        }
    }

    public void handleResetBola(View view) {
        et_jaribola.getText().clear();
        RG_bola.clearCheck();
    }

    public void handleBackBola(View view) {
        Intent backbola = new Intent(this, Menghitung_Menu.class);
        finish();
    }
}