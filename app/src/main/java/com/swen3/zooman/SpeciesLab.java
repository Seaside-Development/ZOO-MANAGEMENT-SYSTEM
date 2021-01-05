package com.swen3.zooman;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.swen3.zooman.database.Cols;
import com.swen3.zooman.database.SpeciesCursorWrapper;
import com.swen3.zooman.database.SpeciesDbSchema;
import com.swen3.zooman.database.DataBaseHandler;
import com.swen3.zooman.database.DataBaseHandlerKt;
import com.swen3.zooman.database.SpeciesDbSchema;
import com.swen3.zooman.database.SpeciesDbSchema.SpeciesTable;

import static com.swen3.zooman.database.SpeciesDbSchema.SpeciesTable.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SpeciesLab {
    private static SpeciesLab sSpeciesLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static SpeciesLab get(Context context) {
        if (sSpeciesLab == null) {
            sSpeciesLab = new SpeciesLab(context);
        }

        return sSpeciesLab;
    }

    private SpeciesLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DataBaseHandler(mContext)
                .getWritableDatabase();

    }

    public List<Species> getSpecies() {
        List<Species> species = new ArrayList<>();
        SpeciesCursorWrapper cursor = querySpecies(Cols.INSTANCE + " = 0", null );
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                species.add(cursor.getSpecies());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return species;
    }

    public Species getSpecies(UUID SpecId) {
        SpeciesCursorWrapper cursor = querySpecies(
                SpeciesTable.Cols.COL_ID + " = ?",
                new String[]{SpecId.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getSpecies();
        } finally {
            cursor.close();
        }
    }

    private SpeciesCursorWrapper querySpecies(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                SpeciesTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return new SpeciesCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Species species) {
        ContentValues values = new ContentValues();
        values.put(SpeciesTable.Cols.COL_ID, species.getSpecID());
        values.put(SpeciesTable.Cols.COL_SPEC, species.getSpecName());
        values.put(SpeciesTable.Cols.COL_CLASS, species.getAniClass());
        values.put(SpeciesTable.Cols.COL_DESC, species.getDescription());
        values.put(SpeciesTable.Cols.COL_FOOD, species.getDiet());

        return values;
    }

}

