package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables

object UsersShortcutsTable
{
    //USERS' SHORTCUTS' BASIC TABLE ->
    const val TABLE_NAME: String = "Users_Shortcuts"
    const val COLUMN_NAME_KEY: String = "Key"
    const val COLUMN_NAME_COLOR: String = "Color"
    const val COLUMN_NAME_TYPE: String = "Type"
    const val COLUMN_NAME_PROJECT_ID: String = "Project_Id"
    //<- USERS' SHORTCUTS' BASIC TABLE

    //USERS' SHORTCUTS' BASIC TABLE OPERATIONS ->
    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME" +
            "($COLUMN_NAME_KEY TEXT,$COLUMN_NAME_COLOR TEXT,$COLUMN_NAME_TYPE TEXT," +
            "$COLUMN_NAME_PROJECT_ID TEXT)"

    const val DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    //<- USERS' SHORTCUTS' BASIC TABLE OPERATIONS
}