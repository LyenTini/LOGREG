package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//1.Exdendeljuk OnpenHelperrel
public class AdatbazisSegito extends SQLiteOpenHelper {

    //2. Adatbázis felépítés
    public static final String DATABASE_NAME = "felhasznalo.db";
    public static final String TABLE_NAME = "felhasznalo";

    //3.Oszlopok
    public static final String COL_1 ="ID";
    public static final String COL_2 ="EMAIL";
    public static final String COL_3 ="FELHNEV";
    public static final String COL_4 ="JELSZO";
    public static final String COL_5 ="TELJESNEV";

    //4.Konstruktor létrehozása
    public AdatbazisSegito(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT UNIQUE NOT NULL , FELHNEV TEXT UNIQUE NOT NULL, JELSZO TEXT NOT NULL,TELJESNEV TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    //5.Adatfelvétel
    public boolean adatRogzites(String email, String felhnev, String jelszo, String teljesnev ){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, felhnev);
        contentValues.put(COL_4, jelszo);
        contentValues.put(COL_5, teljesnev);

        long eredmeny = database.insert(TABLE_NAME, null, contentValues);

        if (eredmeny == -1){
            return false;
        }
        else{
            return true; //Sikeres felvétel esetén true eredmény
        }
    }
    //6. Adatlekérdezés
    public Cursor adatLekerdezes(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor eredmeny = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return eredmeny;
    }


}
