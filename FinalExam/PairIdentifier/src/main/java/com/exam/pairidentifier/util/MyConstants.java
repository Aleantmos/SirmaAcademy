package com.exam.pairidentifier.util;

public enum MyConstants {
    ;
    public final static String PERSONAL_DB_CONNECTION = "jdbc:postgresql://localhost:5432/personal";
    public static final String DATABASE_NAME = "'personal'";

    public static final String DB_INIT_SCRIPT_FILE_PATH = "src/main/resources/createDB.sql";
    public static final String ROUGH_FILE_CONTAINER_PATH = "src/main/resources/rough_file/";
    public static final String CURRENT_FILE_NAME = "employees";




    public static final String GET_DB_COUNT_WITH_DB_NAME = "select count(*) from pg_database where datname = %s";
    //gives the count of all tables in the the current db I am connected to
    public static final String GET_FOR_DB_WITH_NAME_TABLES_COUNT = "select count(*) from information_schema.tables where table_schema = 'public'";


}
