package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb

import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsTable

object ListsDatabase
{
    //DATABASE VARS
    const val DATABASE_VERSION: Int = 1
    const val DATABASE_NAME: String = "LISTS_DB.db"

    fun createListTable(): String
    {return ListsTable.CREATE_TABLE}

    fun deleteListTable(): String
    {return  ListsTable.DELETE_TABLE}
}