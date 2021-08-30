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

public class kubus_menu extends AppCompatActivity {
    private EditText et_sisikubus;
    private RadioGroup RG_kubus;
    private RadioButton rb_volumekubus, rb_luaspermukaankubus;
    private Button bt_hitungkubus, bt_resetkubus, bt_backkubus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kubus_menu);
        et_sisikubus= findViewById(R.id.et_sisikubus);
        RG_kubus= findViewById(R.id.RG_kubus);
        rb_volumekubus= findViewById(R.id.rb_volumekubus);
        rb_luaspermukaankubus= findViewById(R.id.rb_luaspermukaankubus);
        bt_backkubus= findViewById(R.id.bt_backkubus);
        bt_hitungkubus= findViewById(R.id.bt_hitungkubus);
        bt_resetkubus= findViewById(R.id.bt_resetkubus);
    }

    public void handleHitungkubus(View view) {
        Intent hitungkubus = new Intent(this, tampilkubus.class);
        if(et_sisikubus.getText().toString().length()==0){
            et_sisikubus.setError("Harap Diisi!");}
        else{
            double S=Double.parseDouble(et_sisikubus.getText().toString());    hitungkubus.putExtra("et_sisikubus", S);
            int selectedID = RG_kubus.getCheckedRadioButtonId();
            if (selectedID == -1) {
                Toast.makeText(this, "Tidak ada yang dipilih!",Toast.LENGTH_SHORT).show();
            }
            else{
                RadioButton RG_kubus_view = RG_kubus.findViewById(selectedID);
                hitungkubus.putExtra("RG_kubus",RG_kubus_view.getText());
                Toast.makeText(this, "Pilihan Anda Adalah "+ RG_kubus_view.getText(), Toast.LENGTH_SHORT).show();
                startActivity(hitungkubus);
            }
        }

    }

    public void handleResetKubus(View view) {
        et_sisikubus.getText().clear();
        RG_kubus.clearCheck();

    }

    public void handleBackKubus(View view) {
        Intent backkubus = new Intent(this, Menghitung_Menu.class);
        finish();
    }
}