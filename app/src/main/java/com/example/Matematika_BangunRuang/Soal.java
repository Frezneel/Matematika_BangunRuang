package com.example.Matematika_BangunRuang;


import android.os.Parcel;
import android.os.Parcelable;

public class Soal implements Parcelable {
    private String soal;
    private String pilihan1;
    private String pilihan2;
    private String pilihan3;
    private String pilihan4;
    private int jawaban;

    public Soal(){
    }

    public Soal(String soal, String pilihan1, String pilihan2, String pilihan3, String pilihan4, int jawaban) {
        this.soal = soal;
        this.pilihan1 = pilihan1;
        this.pilihan2 = pilihan2;
        this.pilihan3 = pilihan3;
        this.pilihan4 = pilihan4;
        this.jawaban = jawaban;
    }

    protected Soal(Parcel in) {
        soal = in.readString();
        pilihan1 = in.readString();
        pilihan2 = in.readString();
        pilihan3 = in.readString();
        pilihan4 = in.readString();
        jawaban = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(soal);
        dest.writeString(pilihan1);
        dest.writeString(pilihan2);
        dest.writeString(pilihan3);
        dest.writeString(pilihan4);
        dest.writeInt(jawaban);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Soal> CREATOR = new Creator<Soal>() {
        @Override
        public Soal createFromParcel(Parcel in) {
            return new Soal(in);
        }

        @Override
        public Soal[] newArray(int size) {
            return new Soal[size];
        }
    };

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getPilihan1() {
        return pilihan1;
    }

    public void setPilihan1(String pilihan1) {
        this.pilihan1 = pilihan1;
    }

    public String getPilihan2() {
        return pilihan2;
    }

    public void setPilihan2(String pilihan2) {
        this.pilihan2 = pilihan2;
    }

    public String getPilihan3() {
        return pilihan3;
    }

    public void setPilihan3(String pilihan3) {
        this.pilihan3 = pilihan3;
    }

    public String getPilihan4() {
        return pilihan4;
    }

    public void setPilihan4(String pilihan4) {
        this.pilihan4 = pilihan4;
    }

    public int getJawaban() {
        return jawaban;
    }

    public void setJawaban(int jawaban) {
        this.jawaban = jawaban;
    }
}
