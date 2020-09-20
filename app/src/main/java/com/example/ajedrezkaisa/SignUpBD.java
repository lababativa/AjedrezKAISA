package com.example.ajedrezkaisa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SignUpBD extends SQLiteOpenHelper {

    private static final String nombre_bd="signup.bd";
    private static final int version_bd=1;
    private static final String TABLA_REGISTRO="CREATE TABLE REGISTRO(DOCUMENTO TEXT PRIMARY KEY, NOMBRE TEXT, CORREO TEXT, CONTRASENA TEXT)";

    public SignUpBD(Context context){
        super(context, nombre_bd, null, version_bd);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(TABLA_REGISTRO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_REGISTRO);  <- ME SALE ERROR EL "
        sqLiteDatabase.execSQL(TABLA_REGISTRO);
    }

    public void agregarRegistro(String documento, String nombre, String correo, String contrasena){
        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO REGISTRO VALUES('"+documento+"','"+nombre+"','"+correo+"','"+contrasena+"')");
            bd.close();
        }
    }

}
