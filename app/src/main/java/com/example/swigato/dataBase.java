package com.example.swigato;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class dataBase extends SQLiteOpenHelper {

    private  static final String dbMenu="dbMenu.db";

        public dataBase(@Nullable Context context) {
        super(context, dbMenu, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String snackDb="create table users(Name text,Price number,Quantity number)";
        sqLiteDatabase.execSQL(snackDb);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
