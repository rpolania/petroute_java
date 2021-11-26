package com.rp.petroute_java.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "petroute.db";
    protected static final String USERS_TABLE = "usuarios";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + USERS_TABLE + "(" +
                "idUser INTEGER PRIMARY KEY AUTOINCREMENT," +
                "userName TEXT NOT NULL," +
                "password TEXT NOT NULL)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + USERS_TABLE );// Consulta
        onCreate(sqLiteDatabase);


    }
}