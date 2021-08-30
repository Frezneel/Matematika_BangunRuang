package com.example.Matematika_BangunRuang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class tampilbola extends AppCompatActivity {
    private TextView tampil_jaribola,
            rumusbolatampil1,rumusbolatampil2,hasilbola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilbola);
        tampil_jaribola = findViewById(R.id.tampil_jaribola);
        rumusbolatampil1 = findViewById(R.id.rumusbolatampil);
        rumusbolatampil2 = findViewById(R.id.rumusbolatampil2);
        hasilbola = findViewById(R.id.hasilbola);
        Bundle bundle = getIntent().getExtras();

        double jari = bundle.getDouble("et_jaribola");
        String pilihan = bundle.getString("RG_bola");
        tampil_jaribola.setText("Jari-jari(r) = " + jari);

        double hasil;
        String rumus1;
        String rumus2;
        String rumus3;
        if (pilihan.equalsIgnoreCase("VOLUME")) {
            //test 1 (tampil di hasil bola)
            double d = 4 ;
            double e = 3 ;
            double tigaperempat = d / e ;
            hasil = tigaperempat * 3.14 * jari * jari * jari;
            rumus1 = "V = (4/3) X Phi X r X r X r";
            rumus2 = "V = (4/3) X 3.14 X "+jari+" X "+""+jari+" X "+jari;
            rumusbolatampil1.setText(rumus1);
            rumusbolatampil2.setText(rumus2);
            hasilbola.setText("Maka Hasilnya = "+hasil);
            }
        else {
            hasil = 4 * 3.14 * jari * jari;
            rumus1 = "La = 4 X Phi X r X r";
            rumus2 = "La = 4 X 3.14 X "+jari+" X "+jari;
            rumusbolatampil1.setText(rumus1);
            rumusbolatampil2.setText(rumus2);
            hasilbola.setText("Hasil Luas Permukaan= " + hasil);
        }
    }
}