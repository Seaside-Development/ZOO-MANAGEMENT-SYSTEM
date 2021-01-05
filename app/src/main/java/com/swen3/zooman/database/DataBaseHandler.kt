package com.swen3.zooman.database

import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.swen3.zooman.Customer


val DATABASE_NAME="ZooMngMnt"
val TABLE_NAME="Customers"
val COL_EMAIL="email"
val COL_USERNAME="UserName"
val COL_PASS="Password"

class DataBaseHandler (var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,1){

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable="CREATE TABLE " + TABLE_NAME + " (" + COL_EMAIL+ " VARCHAR(50) PRIMARY KEY, " +
                COL_USERNAME + " VARCHAR(50), " +
                COL_PASS + " VARCHAR(50) )"

        db?.execSQL(createTable)
    }

   override fun onUpgrade (db :SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertData(Customer: Customer) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_EMAIL, Customer.email)
        cv.put(COL_USERNAME, Customer.userName)
        cv.put(COL_PASS,Customer.password)

        val result = db.insert(TABLE_NAME,null,cv)
        if (result== (-1).toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }


}