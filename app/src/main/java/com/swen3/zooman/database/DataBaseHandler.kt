package com.swen3.zooman.database


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.swen3.zooman.Customer
import com.swen3.zooman.Species


val DATABASE_NAME="ZooMngMnt"

val TABLE_NAME="Customers"
val COL_EMAIL="email"
val COL_USERNAME="UserName"
val COL_PASS="Password"



const val NAME = "species"
object Cols {
    val COL_ID="SpeciesID"
    val COL_SPEC="Species_Name"
    val COL_CLASS="Animal_CLass"
    val COL_FOOD="Diet"
    val COL_DESC="Description"
}



class DataBaseHandler (var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,1){




    override fun onCreate(db: SQLiteDatabase?) {
        val createSpeciesTable="CREATE TABLE "+ NAME + " ("+ Cols.COL_ID +  " INT PRIMARY KEY, " +
                Cols.COL_SPEC + " VARCHAR(50), " + Cols.COL_CLASS +" VARCHAR(50), " + Cols.COL_FOOD + " VARCHAR(50), " + Cols.COL_DESC + " VARCHAR(100) )"

        db?.execSQL(createSpeciesTable)


        val createCusTable="CREATE TABLE " + TABLE_NAME + " (" + COL_EMAIL+ " VARCHAR(50) PRIMARY KEY, " +
                COL_USERNAME + " VARCHAR(50), " +
                COL_PASS + " VARCHAR(50) )"

        db?.execSQL(createCusTable)





    }

   override fun onUpgrade (db :SQLiteDatabase?, oldVersion: Int, newVersion: Int) {



   }

    fun insertData(customer: Customer) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_EMAIL, customer.email)
        cv.put(COL_USERNAME, customer.userName)
        cv.put(COL_PASS,customer.password)

        val result = db.insert(TABLE_NAME,null,cv)
        if (result== (-1).toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }


    fun readData(): MutableList<Species>
    {
        var list : MutableList<Species> = ArrayList()

        val db=this.readableDatabase
        val query="Select * from "+ NAME
        val result=db.rawQuery(query, null)
        if (result.moveToFirst()){
            do {
                var species = Species()
                species.specID= result.getString(result.getColumnIndex(Cols.COL_ID)).toInt();
                species.specName=result.getString(result.getColumnIndex(Cols.COL_SPEC))
                species.aniClass=result.getString(result.getColumnIndex(Cols.COL_CLASS))
                species.diet=result.getString(result.getColumnIndex(Cols.COL_FOOD))
                species.description=result.getString(result.getColumnIndex(Cols.COL_DESC))
                list.add(species)
            } while (result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }




}