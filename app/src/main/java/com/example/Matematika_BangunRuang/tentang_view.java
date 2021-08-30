package com.example.Matematika_BangunRuang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tentang_view extends AppCompatActivity {
    Button profilcreator, profilaplikasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_view);
        profilcreator = (Button) findViewById(R.id.bt_profil_creator);
        profilaplikasi = (Button) findViewById(R.id.bt_profil_aplikasi);

        profilcreator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new ProfilCreator());
            }
        });

        profilaplikasi.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new ProfilAplikasi());
            }
        });
    }
    private void loadFragment (Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }
}