package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables

object UsersFoldersListsTable
{
    //FOLDERS' LISTS' TABLE ->
    const val FOLDERS_LISTS_TABLE_NAME: String = "Users_Folders_Lists"
    const val FOLDERS_LISTS_COLUMN_NAME_KEY: String = "Key"
    const val FOLDERS_LISTS_COLUMN_NAME_ID: String = "Id"
    //<- FOLDERS' LISTS' TABLE

    //FOLDERS' LISTS' TABLE OPERATIONS ->
    const val FOLDERS_LISTS_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $FOLDERS_LISTS_TABLE_NAME" +
            "($FOLDERS_LISTS_COLUMN_NAME_KEY TEXT,$FOLDERS_LISTS_COLUMN_NAME_ID TEXT)"

    const val FOLDERS_LISTS_DELETE_TABLE = "DROP TABLE IF EXISTS $FOLDERS_LISTS_TABLE_NAME"
    //<- FOLDERS' LISTS' TABLE OPERATIONS
}