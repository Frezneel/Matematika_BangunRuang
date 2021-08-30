package com.example.Matematika_BangunRuang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class tampilkubus extends AppCompatActivity {
    private TextView tampil_sisikubus,
            rumuskubustampil1,rumuskubustampil2,hasilkubus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilkubus);
        tampil_sisikubus = findViewById(R.id.tampil_sisikubus);
        rumuskubustampil1 = findViewById(R.id.rumuskubustampil);
        rumuskubustampil2 = findViewById(R.id.rumuskubustampil2);
        hasilkubus = findViewById(R.id.hasilkubus);
        Bundle bundle = getIntent().getExtras();

        double sisi = bundle.getDouble("et_sisikubus");
        String pilihan = bundle.getString("RG_kubus");
        tampil_sisikubus.setText("SISI(S) = " + sisi);

        double hasil;
        String rumus1;
        String rumus2;
        String rumus3;

        if (pilihan.equalsIgnoreCase("VOLUME")) {
            hasil = sisi * sisi * sisi;
            rumus1 = "V = Sisi X Sisi X Sisi";
            rumus2 = "V = "+sisi+" X "+""+sisi+" X "+sisi;
            rumuskubustampil1.setText(rumus1);
            rumuskubustampil2.setText(rumus2);
            hasilkubus.setText("Hasil Volume= " + hasil);
        }
        else {
            hasil = 6 * sisi * sisi;
            rumus1 = "La = 6 X S X S";
            rumus2 = "La = 6 X "+sisi+" X "+sisi;
            rumuskubustampil1.setText(rumus1);
            rumuskubustampil2.setText(rumus2);
            hasilkubus.setText("Hasil Luas Permukaan= " + hasil);
        }
    }
}