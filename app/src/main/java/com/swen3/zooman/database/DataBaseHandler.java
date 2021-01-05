package com.swen3.zooman.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.swen3.zooman.Customer;
import com.swen3.zooman.Species;


public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "users";
    private static final String DB_TABLE = "userTable";

    //Columns
    private static String EMAIL = "email";
    private static String USERNAME= "UserName";
    private static String PASS= "Password";

    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}