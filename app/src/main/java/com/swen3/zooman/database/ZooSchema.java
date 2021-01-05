package com.swen3.zooman.database;


public class ZooSchema {


    public static final class SpeciesTable {
        public static final String NAME = "AniTable";

        public static final class Cols {
            public static final String speciesID = "SpeciesID";
            public static final String specName = "SpeciesName";
            public static final String aniClass = "AnimalClass";
            public static final String diet = "Diet";
            public static final String desc="description";
        }
    }


    public static final class CustomerTable {
        public static final String NAME = "Customers";

        public static final class Cols {
            public static final String email = "email";
            public static final String userName= "username";
            public static final String password = "Password";

        }
    }

}
