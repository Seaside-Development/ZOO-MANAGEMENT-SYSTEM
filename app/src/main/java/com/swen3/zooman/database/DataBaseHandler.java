package com.swen3.zooman.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "users";
    private static final String DB_TABLE = "userTable";

    //Columns
    private static String EMAIL = "email";
    private static String USERNAME= "UserName";
    private static String PASS= "Password";

    //Query
    private static final String CREATE_TABLE = "CREATE TABLE"+ DB_TABLE+" ("+
            ID
            ""

    public DataBaseHelper( Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}