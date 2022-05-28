package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables

object UsersDateFormatsTable
{
    //USERS' DATE FORMATS' BASIC TABLE ->
    const val TABLE_NAME: String = "Users_Date_Formats"
    const val COLUMN_NAME_KEY: String = "Key"
    const val COLUMN_NAME_DATE: String = "Name"
    const val COLUMN_NAME_START_OF_WEEK: String = "Id"
    const val COLUMN_NAME_TIME: String = "Email"
    //<- USERS' DATE FORMATS' BASIC TABLE

    //USERS' DATE FORMATS' BASIC TABLE OPERATIONS ->
    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME" +
            "($COLUMN_NAME_KEY TEXT,$COLUMN_NAME_DATE TEXT,$COLUMN_NAME_START_OF_WEEK TEXT," +
            "$COLUMN_NAME_TIME TEXT)"

    const val DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    //<- USERS' DATE FORMATS' BASIC TABLE OPERATIONS
}