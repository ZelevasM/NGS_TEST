package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables

object ListsTasksMessagesTable
{
    //LISTS' TASKS' MESSAGES' TABLE ->
    const val TABLE_NAME: String = "Lists_Tasks_Messages"
    const val COLUMN_NAME_KEY: String = "Key"
    const val COLUMN_NAME_ID: String = "Id"
    const val COLUMN_NAME_USER_ID: String = "User_Id"
    const val COLUMN_NAME_MESSAGE: String = "Message"
    const val COLUMN_NAME_DATE: String = "Date"
    //BOOLEAN
    const val COLUMN_NAME_REMOVE_FILE: String = "Remove_File"
    const val COLUMN_NAME_READ: String = "Read"
    //<- LISTS' TASKS' MESSAGES' TABLE

    //TABLES
    //REPLIES
    //FILES

    //LISTS' TASKS' MESSAGES' TABLE OPERATIONS ->
    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME" +
            "($COLUMN_NAME_KEY TEXT,$COLUMN_NAME_REMOVE_FILE TEXT," +
            "$COLUMN_NAME_READ TEXT,$COLUMN_NAME_ID TEXT," +
            "$COLUMN_NAME_MESSAGE TEXT, $COLUMN_NAME_USER_ID," +
            "$COLUMN_NAME_DATE)"

    const val DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    //<- LISTS' TASKS' MESSAGES' TABLE OPERATIONS
}