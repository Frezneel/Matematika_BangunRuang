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

public class tabung_menu extends AppCompatActivity {
    private EditText et_jaritabung, et_tinggitabung;
    private RadioGroup RG_tabung;
    private RadioButton rb_volumetabung, rb_luaspermukaantabung;
    private Button bt_hitungtabung, bt_resettabung, bt_backtabung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabung_menu);
        et_jaritabung= findViewById(R.id.et_jaritabung);
        et_tinggitabung= findViewById(R.id.et_tinggitabung);
        RG_tabung= findViewById(R.id.RG_tabung);
        rb_volumetabung= findViewById(R.id.rb_volumetabung);
        rb_luaspermukaantabung= findViewById(R.id.rb_luaspermukaantabung);
        bt_backtabung= findViewById(R.id.bt_backtabung);
        bt_hitungtabung= findViewById(R.id.bt_hitungtabung);
        bt_resettabung= findViewById(R.id.bt_resettabung);
    }

    public void handleHitungTabung(View view) {
        Intent hitungtabung = new Intent(this, tampiltabung.class);
        if(et_jaritabung.getText().toString().length()==0){
            et_jaritabung.setError("Harap Diisi!");}
        else{
                if(et_tinggitabung.getText().toString().length()==0)
                {
                    et_tinggitabung.setError("Harap Diisi!");
                }
                else {
                    double r = Double.parseDouble(et_jaritabung.getText().toString());
                    hitungtabung.putExtra("et_jaritabung", r);
                    double T = Double.parseDouble(et_tinggitabung.getText().toString());
                    hitungtabung.putExtra("et_tinggitabung", T);
                    int selectedID = RG_tabung.getCheckedRadioButtonId();
                    if (selectedID == -1) {
                        Toast.makeText(this, "Tidak ada yang dipilih!", Toast.LENGTH_SHORT).show();
                    } else {
                        RadioButton RG_tabung_view = RG_tabung.findViewById(selectedID);
                        hitungtabung.putExtra("RG_tabung", RG_tabung_view.getText());
                        Toast.makeText(this, "Pilihan Anda Adalah " + RG_tabung_view.getText(), Toast.LENGTH_SHORT).show();
                        startActivity(hitungtabung);
                    }
                }
            }
        }

    public void handleResetTabung(View view) {
        et_jaritabung.getText().clear();
        et_tinggitabung.getText().clear();
        RG_tabung.clearCheck();
    }

    public void handleBackTabung(View view) {
        Intent backtabung= new Intent(this, Menghitung_Menu.class);
        finish();
    }
}