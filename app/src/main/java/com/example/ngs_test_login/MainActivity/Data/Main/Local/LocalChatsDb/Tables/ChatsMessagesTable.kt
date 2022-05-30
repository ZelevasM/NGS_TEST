package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Tables

object ChatsMessagesTable
{
    //CHATS' MESSAGES' BASIC TABLE ->
    const val TABLE_NAME: String = "Chats_Messages"
    const val COLUMN_NAME_KEY: String = "Key"
    const val COLUMN_NAME_ID: String = "Id"
    const val COLUMN_NAME_USER_ID: String = "User_Id"
    const val COLUMN_NAME_DATE: String = "Date"
    const val COLUMN_NAME_REPLY: String = "Reply"
    const val COLUMN_NAME_MESSAGE: String = "Message"
    //BOOLEAN
    const val COLUMN_NAME_READ: String = "Read"

    //TABLES
    //FILES

    //<- CHATS' MESSAGES' BASIC TABLE date + order?

    //CHATS' MESSAGES' BASIC TABLE OPERATIONS ->
    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME" +
            "($COLUMN_NAME_KEY TEXT,$COLUMN_NAME_ID TEXT,$COLUMN_NAME_USER_ID TEXT," +
            "$COLUMN_NAME_DATE TEXT,$COLUMN_NAME_REPLY TEXT, $COLUMN_NAME_MESSAGE TEXT," +
            "$COLUMN_NAME_READ TEXT)"

    const val DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    //<- CHATS' MESSAGES' BASIC TABLE OPERATIONS
}