package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Tables

object ChatsTable
{
    //CHATS' BASIC TABLE ->
    const val TABLE_NAME: String = "Lists"
    const val COLUMN_NAME_DATE: String = "Date"
    const val COLUMN_NAME_AUTHOR: String = "Author"
    const val COLUMN_NAME_PROJECT_ID: String = "Project_Id"
    const val COLUMN_NAME_VERSION: String = "Version"
    const val COLUMN_NAME_NAME: String = "Name"
    const val COLUMN_NAME_ID: String = "Id"
    //<- CHATS' BASIC TABLE date + order?

    //TABLES
    //MESSAGES
    //USERS

    //CHATS' BASIC TABLE OPERATIONS ->
    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME" +
            "($COLUMN_NAME_DATE TEXT,$COLUMN_NAME_AUTHOR TEXT,$COLUMN_NAME_PROJECT_ID TEXT," +
            "$COLUMN_NAME_VERSION TEXT,$COLUMN_NAME_NAME TEXT, $COLUMN_NAME_ID)"

    const val DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    //<- CHATS' BASIC TABLE OPERATIONS

    //Add insert/update/delete for each parameter
}