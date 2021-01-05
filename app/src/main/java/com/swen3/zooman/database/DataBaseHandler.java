package com.swen3.zooman.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "users";
    private static final String DB_TABLE = "userTable";

    //Columns
    private static String EMAIL = "email";
    private static String USERNAME= "username";
    private static String PASS= "password";

    //Query
    private static final String CREATE_TABLE = "CREATE TABLE "+ DB_TABLE+" ("+
            EMAIL + "VARCHAR PRIMARY KEY AUTOINCREMENT," +
    USERNAME + "TEXT " + PASS + "TEXT" + ")";

    public DataBaseHelper( Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);

        onCreate(db);
    }

    //CREATE METHOD TO INSERT DATA
    public boolean insertData(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EMAIL, email);

        long result = db.insert(DB_TABLE, null, contentValues);
        return result != -1; //if result =-1 doesn't insert
    }

}