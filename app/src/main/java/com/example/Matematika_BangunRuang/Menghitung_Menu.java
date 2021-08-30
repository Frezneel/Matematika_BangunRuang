package com.example.Matematika_BangunRuang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menghitung_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menghitung__menu);
    }

    public void handleBackMenu1(View view) {
        Intent backmenu1 = new Intent(this, MainActivity.class);
        finish();
    }

    public void handleMenuBalok(View view) {
        Intent balok = new Intent(this, balok_menu.class);
        Toast.makeText(this, "Pilihan Anda adalah Balok", Toast.LENGTH_SHORT).show();
        startActivity(balok);
    }

    public void handleMenuKubus(View view) {
        Intent kubus = new Intent(this, kubus_menu.class);
        Toast.makeText(this, "Pilihan Anda adalah Kubus", Toast.LENGTH_SHORT).show();
        startActivity(kubus);
    }

    public void handleMenuBola(View view) {
        Intent bola = new Intent(this, bola_menu.class);
        Toast.makeText(this, "Pilihan Anda adalah Bola", Toast.LENGTH_SHORT).show();
        startActivity(bola);
    }

    public void handleMenuTabung(View view) {
        Intent tabung = new Intent(this, tabung_menu.class);
        Toast.makeText(this, "Pilihan Anda adalah Tabung", Toast.LENGTH_SHORT).show();
        startActivity(tabung);
    }
}