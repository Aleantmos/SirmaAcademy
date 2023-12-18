package com.exam.pairidentifier.util;

public enum MyConstants {
    ;


    public static final String DATABASE_NAME = "'personal'";

    public static final String DB_INIT_SCRIPT_FILE_PATH = "src/main/resources/createDB.sql";




    public static final String GET_DB_COUNT_WITH_DB_NAME = "select count(*) from pg_database where datname = %s";
}
