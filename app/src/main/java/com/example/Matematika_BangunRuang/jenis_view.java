package com.example.Matematika_BangunRuang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class jenis_view extends AppCompatActivity {
    android.widget.ListView jenis_list;
    String[] jenis={
            "Balok", "Kubus", "Bola", "Prisma Segi Lima", "Tabung", "Kerucut",
            "Limas Segi Tiga", "Limas Segi Empat"};
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis_view);
        jenis_list=findViewById(R.id.jenis_list);
        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,jenis);
        jenis_list.setAdapter(arrayAdapter);

        jenis_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String index= jenis_list.getItemAtPosition(position).toString();
                Toast.makeText(jenis_view.this,"Pilihan Anda adalah: "+index,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}