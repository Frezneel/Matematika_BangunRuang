package com.example.Matematika_BangunRuang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Launcher extends AppCompatActivity {
Button bt_start;
EditText nama_awal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        bt_start=findViewById(R.id.bt_start);
        nama_awal=findViewById(R.id.nama_awal);
    }

    public void handleStart(View view) {
        Intent start = new Intent(this, MainActivity.class);
        start.putExtra("nama_awal",nama_awal.getText().toString());
        startActivity(start);
    }
}