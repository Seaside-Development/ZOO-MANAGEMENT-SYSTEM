package com.swen3.zooman.database

import android.database.Cursor
import android.database.CursorWrapper
import com.swen3.zooman.Species
import com.swen3.zooman.database.SpeciesDbSchema.SpeciesTable

class SpeciesCursorWrapper(cursor: Cursor?) : CursorWrapper(cursor) {
    val species: Species
        get() {
            val specID = getInt(getColumnIndex(SpeciesTable.Cols.COL_ID))
            val specName = getString(getColumnIndex(SpeciesTable.Cols.COL_SPEC))
            val aniClass = getString(getColumnIndex(SpeciesTable.Cols.COL_CLASS))
            val description = getString(getColumnIndex(SpeciesTable.Cols.COL_DESC))
            val diet = getString(getColumnIndex(SpeciesTable.Cols.COL_FOOD))
            val species = Species(specID)
            species.specName
            species.aniClass
            species.description
            species.diet
            return species
        }
}