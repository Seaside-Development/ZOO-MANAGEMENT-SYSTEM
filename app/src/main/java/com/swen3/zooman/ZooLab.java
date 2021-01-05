package com.swen3.zooman;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import com.swen3.zooman.database.ZooMngHelper;


//import com.bignerdranch.android.criminalintent.database.CrimeCursorWrapper;


public class ZooLab {
    private static ZooLab sZooLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static ZooLab get(Context context) {
        if (sZooLab == null) {
            sZooLab = new ZooLab(context);
        }

        return sZooLab;
    }

    private ZooLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new ZooMngHelper(mContext)
                .getWritableDatabase();

    }


/*
    public List<Crime> getCrimes() {
        List<Crime> crimes = new ArrayList<>();
        CrimeCursorWrapper cursor = queryCrimes(Cols.ARCHIVED + " = 0", null );
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                crimes.add(cursor.getCrime());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return crimes;
    }

    public List<Crime> getArchives() {
        List<Crime> archives = new ArrayList<>();
        CrimeCursorWrapper cursor = queryCrimes(Cols.ARCHIVED + " = 1", null );
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                archives.add(cursor.getCrime());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return archives;
    }

    public Crime getCrime(UUID id) {
        CrimeCursorWrapper cursor = queryCrimes(
                CrimeTable.Cols.UUID + " = ?",
                new String[]{id.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getCrime();
        } finally {
            cursor.close();
        }
    }

    public File getPhotoFile(Crime crime) {
        File filesDir = mContext.getFilesDir();
        return new File(filesDir, crime.getPhotoFilename());
    }

    public void updateCrime(Crime crime) {
        String uuidString = crime.getId().toString();
        ContentValues values = getContentValues(crime);
        mDatabase.update(CrimeTable.NAME, values,
                CrimeTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    private CrimeCursorWrapper queryCrimes(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                CrimeTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return new CrimeCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Crime crime) {
        ContentValues values = new ContentValues();
        values.put(UUID, crime.getId().toString());
        values.put(TITLE, crime.getTitle());
        values.put(DATE, crime.getDate().getTime());
        values.put(DETAILS, crime.getDetails());
        values.put(SOLVEDETAILS, crime.getSolveDetails());
        values.put(SOLVED, crime.isSolved() ? 1 : 0);
        values.put(ARCHIVED, crime.isArchived() ? 1 : 0);
        values.put(CrimeTable.Cols.SUSPECT, crime.getSuspect());
        values.put(v2_LATITUDE, crime.getLatitude());
        values.put(v2_LONGITUDE, crime.getLongitude());

        return values;
    }*/
}

