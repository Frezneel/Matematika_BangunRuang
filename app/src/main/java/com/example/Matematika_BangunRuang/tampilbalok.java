package com.example.Matematika_BangunRuang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class tampilbalok extends AppCompatActivity {
    private TextView tampil_panjangbalok, tampil_lebarbalok, tampil_tinggibalok,
            rumusbaloktampil1,rumusbaloktampil2,hasilbalok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilbalok);
        tampil_panjangbalok = findViewById(R.id.tampil_panjangbalok);
        tampil_lebarbalok = findViewById(R.id.tampil_lebarbalok);
        tampil_tinggibalok = findViewById(R.id.tampil_tinggibalok);
        rumusbaloktampil1 = findViewById(R.id.rumusbaloktampil);
        rumusbaloktampil2 = findViewById(R.id.rumusbaloktampil2);
        hasilbalok = findViewById(R.id.hasilbalok);
        Bundle bundle = getIntent().getExtras();

        double panjang = bundle.getDouble("et_panjangbalok");
        double lebar = bundle.getDouble("et_lebarbalok");
        double tinggi = bundle.getDouble("et_tinggibalok");
        String pilihan = bundle.getString("RG_balok");

        tampil_tinggibalok.setText("Tinggi (T) = " + tinggi);
        tampil_lebarbalok.setText("Lebar(L) = " + lebar);
        tampil_panjangbalok.setText("Panjang(P) = " + panjang);

        double hasil;
        String rumus1;
        String rumus2;
        String rumus3;

        if (pilihan.equalsIgnoreCase("VOLUME")) {
            hasil = panjang * lebar * tinggi;
            rumus1 = "V = Panjang X Lebar X Tinggi";
            rumus2 = "V = "+panjang+" X "+""+lebar+" X "+tinggi;
            rumusbaloktampil1.setText(rumus1);
            rumusbaloktampil2.setText(rumus2);
            hasilbalok.setText("Hasil Volume= " + hasil);
        }
        else {
            hasil = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
            rumus1 = "La = 2 X ((P X L)+(P X T)+(L X T))";
            rumus2 = "La = 2 X (("+panjang+" X "+lebar+") + ("+panjang+" X "+tinggi+") X ("+lebar+" X "+tinggi+"))";
            rumusbaloktampil1.setText(rumus1);
            rumusbaloktampil2.setText(rumus2);
            hasilbalok.setText("Hasil Luas Permukaan= " + hasil);
        }
    }
}