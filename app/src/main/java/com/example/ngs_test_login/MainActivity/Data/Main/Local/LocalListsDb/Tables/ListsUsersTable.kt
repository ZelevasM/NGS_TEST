package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables

object ListsUsersTable
{
    //LISTS' USERS' TABLE ->
    const val TABLE_NAME: String = "Lists_Users"
    const val COLUMN_NAME_KEY: String = "Key"
    const val COLUMN_NAME_ID: String = "Id"
    const val COLUMN_NAME_ORDER: String = "Lists_Users_Order"
    const val COLUMN_NAME_NOTE_SIZE: String = "Note_Size"
    const val COLUMN_NAME_LAST_SEEN: String = "Last_Seen"
    //Int
    const val COLUMN_NAME_UNREAD_MESSAGE: String = "Unread_Message"
    //BOOLEAN
    const val COLUMN_NAME_MUTED: String = "Muted"

    //<- LISTS' USERS' TABLE

    //LISTS' USERS' TABLE OPERATIONS ->
    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME" +
            "($COLUMN_NAME_KEY TEXT,$COLUMN_NAME_ID TEXT," +
            "$COLUMN_NAME_ORDER TEXT,$COLUMN_NAME_NOTE_SIZE TEXT," +
            "$COLUMN_NAME_LAST_SEEN TEXT," +
            "$COLUMN_NAME_UNREAD_MESSAGE INTEGER, $COLUMN_NAME_MUTED TEXT)"

    const val DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    //<- LISTS' USERS' TABLE OPERATIONS
}