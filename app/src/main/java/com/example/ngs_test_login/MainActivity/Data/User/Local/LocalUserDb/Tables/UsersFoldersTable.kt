package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables

object UsersFoldersTable
{
    //FOLDERS' TABLE ->
    const val FOLDERS_TABLE_NAME: String = "Users_Folders"
    const val FOLDERS_COLUMN_NAME_KEY: String = "Key"
    const val FOLDERS_COLUMN_NAME_ID: String = "Id"
    const val FOLDERS_COLUMN_NAME_NAME: String = "Name"
    const val FOLDERS_COLUMN_NAME_ORDER: String = "Folder_Order"
    //<- FOLDERS' TABLE

    //FOLDERS' TABLE OPERATIONS ->
    const val FOLDERS_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $FOLDERS_TABLE_NAME" +
            "($FOLDERS_COLUMN_NAME_KEY TEXT,$FOLDERS_COLUMN_NAME_ID TEXT," +
            "$FOLDERS_COLUMN_NAME_NAME TEXT,$FOLDERS_COLUMN_NAME_ORDER TEXT)"

    const val FOLDERS_DELETE_TABLE = "DROP TABLE IF EXISTS $FOLDERS_TABLE_NAME"
    //<- FOLDERS' TABLE OPERATIONS
}