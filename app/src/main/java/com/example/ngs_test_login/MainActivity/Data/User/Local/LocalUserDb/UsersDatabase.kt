package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb

import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.*

//RENAME TO DATA CLASS
object UsersDatabase
{
    //DATABASE VARS
    const val DATABASE_VERSION: Int = 1
    const val DATABASE_NAME: String = "USER_DB.db"

    fun createUserTable(): String
    {return UsersTable.CREATE_TABLE}

    fun deleteUserTable(): String
    {return  UsersTable.DELETE_TABLE}

    fun createFoldersTable(): String
    {return UsersFoldersTable.FOLDERS_CREATE_TABLE}

    fun deleteFoldersTable(): String
    {return UsersFoldersTable.FOLDERS_DELETE_TABLE}

    fun createFoldersListsTable(): String
    {return UsersFoldersListsTable.FOLDERS_LISTS_CREATE_TABLE}

    fun deleteFoldersListsTable(): String
    {return UsersFoldersListsTable.FOLDERS_LISTS_DELETE_TABLE}

    fun createDateFormatsTable(): String
    {return UsersDateFormatsTable.CREATE_TABLE}

    fun deleteDateFormatsTable(): String
    {return UsersDateFormatsTable.DELETE_TABLE}

    fun createShortcutsTable(): String
    {return UsersShortcutsTable.CREATE_TABLE}

    fun deleteShortcutsTable(): String
    {return UsersShortcutsTable.DELETE_TABLE}
}