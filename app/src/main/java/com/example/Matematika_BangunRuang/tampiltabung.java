package com.example.Matematika_BangunRuang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class tampiltabung extends AppCompatActivity {
    private TextView tampil_jaritabung, tampil_tinggitabung,
            rumustabungtampil1,rumustabungtampil2,hasiltabung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampiltabung);
        tampil_jaritabung = findViewById(R.id.tampil_jaritabung);
        tampil_tinggitabung = findViewById(R.id.tampil_tinggitabung);
        rumustabungtampil1 = findViewById(R.id.rumustabungtampil);
        rumustabungtampil2 = findViewById(R.id.rumustabungtampil2);
        hasiltabung = findViewById(R.id.hasiltabung);
        Bundle bundle = getIntent().getExtras();

        double jari = bundle.getDouble("et_jaritabung");
        double tinggi = bundle.getDouble("et_tinggitabung");
        String pilihan = bundle.getString("RG_tabung");

        tampil_tinggitabung.setText("Tinggi (T) = " + tinggi);
        tampil_jaritabung.setText("Panjang Jari-jari(r) = " + jari);

        double hasil;
        String rumus1;
        String rumus2;
        String rumus3;

        if (pilihan.equalsIgnoreCase("VOLUME")) {
            hasil = 3.14 * jari * jari * tinggi;
            rumus1 = "V = Phi X r X r X Tinggi";
            rumus2 = "V = 3.14 X "+jari+" X "+jari+" X "+tinggi;
            rumustabungtampil1.setText(rumus1);
            rumustabungtampil2.setText(rumus2);
            hasiltabung.setText("Hasil Volume= " + hasil);
        }
        else {
            hasil = 2 * 3.14 * jari * ( jari + tinggi );
            rumus1 = "Lp = 2 X 3.14 X r X( r + tinggi )";
            rumus2 = "Lp = 2 X 3.14 X "+jari+" X ( "+jari+" + "+tinggi+" )";
            rumustabungtampil1.setText(rumus1);
            rumustabungtampil2.setText(rumus2);
            hasiltabung.setText("Hasil Luas Permukaan= " + hasil);
        }
    }
}