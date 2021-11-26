package com.rp.petroute_java.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

public class DbUsers extends DbHelper{

    //private static final String USERS_TABLE = ;
    Context context; // Variable global



    public DbUsers(@Nullable Context context) {
        super(context);
        this.context = context;
    }


    public Boolean insertUser(String userName, String password){
        DbHelper dbHelper = new DbHelper(context); // Instancia del objeto DbHleper = nuestra base de datos
        SQLiteDatabase db = dbHelper.getWritableDatabase(); // Agregamos los datos

        ContentValues values = new ContentValues(); // Instancia del objeto values
        values.put("userName", userName);
        values.put("password", password);
        values.put("correo", password);

        long result = db.insert(USERS_TABLE, null, values);
        if (result == -1) return false;
        else
            return true;

    }

    public Boolean checkUserName(String userName){ //esta es ka qye esta llegando null
        DbHelper dbHelper = new DbHelper(context); // Instancia del objeto DbHelper
        SQLiteDatabase db = dbHelper.getWritableDatabase(); //

        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE userName =?", new String[] {userName});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkPassword(String userName, String password){
        DbHelper dbHelper = new DbHelper(context); // Instaciamos nuestra conexión
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE userName =? and password=?", new String[] {userName, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}

//        long id = 0;
//
//        try{
//            DbHelper dbHelper = new DbHelper(context); // Intancia del objeto DbHleper = nuestra base de datos
//            SQLiteDatabase db = dbHelper.getWritableDatabase(); // Agregamos los datos
//
//            ContentValues values = new ContentValues(); // Instancia del objeto values
//            values.put("nomusuario", nomusuario);
//            values.put("contrasena", contrasena);
//
//            id = db.insert(TABLE_USERS, null, values);
//
//        } catch (Exception ex){
//            ex.toString();
//        }
//
//
//        return id;



