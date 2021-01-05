package com.swen3.zooman.database

class SpeciesDbSchema {
    object SpeciesTable {
        lateinit var SpecID: String
        const val NAME = "species"

        object Cols {
            const val COL_ID = "SpeciesID"
            const val COL_SPEC = "Species_Name"
            const val COL_CLASS = "Animal_CLass"
            const val COL_FOOD = "Diet"
            const val COL_DESC = "Description"
        }
    }
}