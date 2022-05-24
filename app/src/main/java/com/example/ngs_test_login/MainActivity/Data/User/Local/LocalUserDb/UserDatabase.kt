package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb

import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.FoldersListsTable
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.FoldersTable
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.UserTable

//RENAME TO DATA CLASS
object UserDatabase
{
    //DATABASE VARS
    const val DATABASE_VERSION: Int = 1
    const val DATABASE_NAME: String = "USER_DB.db"

    fun createUserTable(): String
    {return UserTable.CREATE_TABLE}

    fun deleteUserTable(): String
    {return  UserTable.DELETE_TABLE}

    fun createFoldersTable(): String
    {return FoldersTable.FOLDERS_CREATE_TABLE}

    fun deleteFoldersTable(): String
    {return FoldersTable.FOLDERS_DELETE_TABLE}

    fun createFoldersListsTable(): String
    {return FoldersListsTable.FOLDERS_LISTS_CREATE_TABLE}

    fun deleteFoldersListsTable(): String
    {return FoldersListsTable.FOLDERS_LISTS_DELETE_TABLE}
}