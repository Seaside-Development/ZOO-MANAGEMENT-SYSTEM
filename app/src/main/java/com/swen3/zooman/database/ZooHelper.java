package com.swen3.zooman.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.swen3.zooman.database.ZooSchema.*;



public class ZooHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "ZooMan.db";

    public ZooHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + SpeciesTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                SpeciesTable.Cols.speciesID + ", " +
                SpeciesTable.Cols.aniClass + ", " +
                SpeciesTable.Cols.diet + ", " +
                SpeciesTable.Cols.desc +
                ")"
        );

        db.execSQL("create table " + CustomerTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                CustomerTable.Cols.email + ", " +
                CustomerTable.Cols.userName + ", " +
                CustomerTable.Cols.password +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}