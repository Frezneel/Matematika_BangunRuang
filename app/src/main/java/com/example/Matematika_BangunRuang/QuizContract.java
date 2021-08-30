package com.example.Matematika_BangunRuang;

import android.provider.BaseColumns;

public final class QuizContract {

    private QuizContract(){}

    public static class tabelpertanyaan implements BaseColumns {
        public static final String TABLE_NAME = "soal_quiz";
        public static final String COULUMN_QUESTION = "soal";
        public static final String COULUMN_OPTION1 = "pilihan1";
        public static final String COULUMN_OPTION2 = "pilihan2";
        public static final String COULUMN_OPTION3 = "pilihan3";
        public static final String COULUMN_OPTION4 = "pilihan4";
        public static final String COULUMN_ANSWER_NR = "jawaban";



    }
}
