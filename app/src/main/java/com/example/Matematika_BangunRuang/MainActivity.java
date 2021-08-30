package com.example.Matematika_BangunRuang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t = (TextView) findViewById(R.id.tampil_nama_awal);
        Bundle bundle = getIntent().getExtras();
        String s = bundle.getString("nama_awal");
        t.setText(s);
    }

    public void handleMenghitung(View view) {
        Intent menghitung = new Intent(this, Menghitung_Menu.class);
        startActivity(menghitung);
    }

    public void handleYoutube(View view) {
        Intent website = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/channel/UCTGfpLzK-jgquKNcO9L0gSA"));
        startActivity(website);

    }

    public void handleJenis(View view) {
        Intent jenis = new Intent(this, jenis_view.class);
        startActivity(jenis);
    }

    public void handleTentang(View view) {
        Intent tentang = new Intent(this, tentang_view.class);
        startActivity(tentang);
    }

    public void handleQuiz(View view) {
        Intent quiz = new Intent(this, Quiz_menu.class);
        startActivity(quiz);
    }
}