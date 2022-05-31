package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables

object UsersTable
{
    //USER BASIC TABLE ->
    const val TABLE_NAME: String = "Users"
    const val COLUMN_NAME_NAME: String = "Name"
    const val COLUMN_NAME_ID: String = "Id"
    const val COLUMN_NAME_EMAIL: String = "Email"
    const val COLUMN_NAME_LANGUAGE: String = "Language"
    const val COLUMN_NAME_HOMEPAGE_ID: String = "Homepage"
    //BOOLEAN
    const val COLUMN_NAME_SIDEBAR: String = "Sidebar"
    const val COLUMN_NAME_DISK_SPACE: String = "DiskSpace"
    //BOOLEAN
    const val COLUMN_NAME_EXPAND_SUBTASK: String = "Subtask"
    //BOOLEAN
    const val COLUMN_NAME_NEW_TASK: String = "NewTask"
    const val COLUMN_NAME_SHORTCUT_INBOX: String = "ShortcutInbox"
    //<- USER BASIC TABLE

    //USER BASIC TABLE OPERATIONS ->
    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME" +
            "($COLUMN_NAME_NAME TEXT,$COLUMN_NAME_ID TEXT,$COLUMN_NAME_EMAIL TEXT,$COLUMN_NAME_LANGUAGE TEXT," +
            "$COLUMN_NAME_SIDEBAR INTEGER,$COLUMN_NAME_DISK_SPACE TEXT," +
            "$COLUMN_NAME_EXPAND_SUBTASK INTEGER,$COLUMN_NAME_NEW_TASK INTEGER," +
            "$COLUMN_NAME_HOMEPAGE_ID TEXT,$COLUMN_NAME_SHORTCUT_INBOX TEXT)"

    const val DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    //<- USER'S BASIC TABLE OPERATIONS
}