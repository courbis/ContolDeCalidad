package com.example.courbis.contoldecalidad.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by courbis on 28-08-16.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Creacion de tabla
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuario(rut text primary key,nombre text, apellido_paterno text, apellido_materno text, pass text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exist usuario");
        db.execSQL("create table usuario(rut text primary key,nombre text, apellido_paterno text, apellido_materno text, pass text)");
    }
}
