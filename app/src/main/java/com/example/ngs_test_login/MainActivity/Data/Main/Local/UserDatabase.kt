package com.example.ngs_test_login.MainActivity.Data.Main.Local

//RENAME TO DATA CLASS
object UserDatabase
{
    const val TABLE_NAME: String = "User"
    const val COLUMN_NAME_NAME: String = "Name"
    const val COLUMN_NAME_ID: String = "Id"
    const val COLUMN_NAME_EMAIL: String = "Email"
    const val COLUMN_NAME_LANGUAGE: String = "Language"
    const val COLUMN_NAME_SIDEBAR: String = "Sidebar"
    const val COLUMN_NAME_DISKS_SPACE: String = "DiskSpace"
    //List
    const val COLUMN_NAME_FOLDERS: String = "Folders"
    const val COLUMN_NAME_EXPAND_SUBTASK: String = "Subtask"
    const val COLUMN_NAME_NEW_TASK: String = "NewTask"
    //TABLE
    const val COLUMN_NAME_HOMEPAGE_ID: String = "Homepage"
    //TABLE
    const val COLUMN_NAME_DATE_FORMAT_ID: String = "DateFormatId"
    //List
    const val COLUMN_NAME_SHORTCUTS_ID: String = "Shortcuts"
    const val COLUMN_NAME_SHORTCUT_INBOX: String = "ShortcutInbox"


    const val DATABASE_VERSION: Int = 1
    const val DATABASE_NAME: String = "USER_DB.db"


    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME" +
            "($COLUMN_NAME_NAME TEXT,$COLUMN_NAME_ID TEXT,$COLUMN_NAME_EMAIL TEXT,$COLUMN_NAME_LANGUAGE TEXT," +
            "$COLUMN_NAME_SIDEBAR BOOLEAN,$COLUMN_NAME_DISKS_SPACE TEXT,$COLUMN_NAME_FOLDERS TEXT," +
            "$COLUMN_NAME_EXPAND_SUBTASK BOOLEAN,$COLUMN_NAME_NEW_TASK BOOLEAN," +
            "$COLUMN_NAME_HOMEPAGE_ID TEXT,$COLUMN_NAME_DATE_FORMAT_ID TEXT," +
            "$COLUMN_NAME_SHORTCUTS_ID TEXT,$COLUMN_NAME_SHORTCUT_INBOX TEXT)"

    const val DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}