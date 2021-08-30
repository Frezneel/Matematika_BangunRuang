package com.example.Matematika_BangunRuang;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.Matematika_BangunRuang.QuizContract.*;

import java.util.ArrayList;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "matematikaquiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Membuat Database
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;

        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE "+
                tabelpertanyaan.TABLE_NAME + " ( "+
                tabelpertanyaan._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                tabelpertanyaan.COULUMN_QUESTION + " TEXT, "+
                tabelpertanyaan.COULUMN_OPTION1 + " TEXT, "+
                tabelpertanyaan.COULUMN_OPTION2 + " TEXT, "+
                tabelpertanyaan.COULUMN_OPTION3 + " TEXT, "+
                tabelpertanyaan.COULUMN_OPTION4 + " TEXT, "+
                tabelpertanyaan.COULUMN_ANSWER_NR + " INTEGER"+
                ")";

        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        fillQuestionTable();

    }

    //Membuat Telah Dibuat
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tabelpertanyaan.TABLE_NAME);
        onCreate(db);
    }

    //Membuat isi Table
    public void fillQuestionTable(){
        Soal s1 = new Soal("Pak Jono punya Lemari yang berbentuk Balok dengan panjang 100cm, tinggi 150cm, dan lebar 50cm. \nBerapakah Volume Lemari Pak Jono ? ", "A. 750 cm³", "B. 375 cm³", "C. 750 m³", "D. 375 m³",3);
        addSoal(s1);
        Soal s2 = new Soal("Beni habis beli sebuah bola yang berdiameter 42cm. \nbola tersebut memiliki Volume ....", "A. 38,772 m³", "B.55,389 m³", "C. 38,772 cm³", "D. 55,389 cm³",1);
        addSoal(s2);
        Soal s3 = new Soal("Tukang kayu mau membuat sebuah lemari berbentuk kubus dengan panjang sisinya 55cm. \nJadi berapa luas permukaan kubus tersebut ?", "A. 18,150 cm²", "B. 18,150 m²", "C. 12,100 cm²", "D. 12,100 m²",2);
        addSoal(s3);
        Soal s4 = new Soal("Ibu sedang mengisi sebuah bak mandi yang berbentuk tabung dengan jari-jari 70cm dan tinggi 120cm. \nBerapa Volume air yang akan terisi pada bakmandi ?", "A. 18.480 m³", "B. 17.220 m³", "C. 19.880 m³", "D. 16.440 m³",1);
        addSoal(s4);
    }

    private void addSoal(Soal soal){
        ContentValues cv = new ContentValues();
        cv.put(tabelpertanyaan.COULUMN_QUESTION, soal.getSoal());
        cv.put(tabelpertanyaan.COULUMN_OPTION1, soal.getPilihan1());
        cv.put(tabelpertanyaan.COULUMN_OPTION2, soal.getPilihan2());
        cv.put(tabelpertanyaan.COULUMN_OPTION3, soal.getPilihan3());
        cv.put(tabelpertanyaan.COULUMN_OPTION4, soal.getPilihan4());
        cv.put(tabelpertanyaan.COULUMN_ANSWER_NR, soal.getJawaban());
        db.insert(tabelpertanyaan.TABLE_NAME, null, cv);

    }

    public ArrayList<Soal> getAllQuestion(){
        ArrayList<Soal> soalList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+ tabelpertanyaan.TABLE_NAME, null);

        if (c.moveToFirst()){
            do {
                Soal soal = new Soal();
                soal.setSoal(c.getString(c.getColumnIndex(tabelpertanyaan.COULUMN_QUESTION)));
                soal.setPilihan1(c.getString(c.getColumnIndex(tabelpertanyaan.COULUMN_OPTION1)));
                soal.setPilihan2(c.getString(c.getColumnIndex(tabelpertanyaan.COULUMN_OPTION2)));
                soal.setPilihan3(c.getString(c.getColumnIndex(tabelpertanyaan.COULUMN_OPTION3)));
                soal.setPilihan4(c.getString(c.getColumnIndex(tabelpertanyaan.COULUMN_OPTION4)));
                soal.setJawaban(c.getInt(c.getColumnIndex(tabelpertanyaan.COULUMN_ANSWER_NR)));
                soalList.add(soal);
            }while (c.moveToNext());
        }
        c.close();
        return soalList;
    }
}
