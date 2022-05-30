package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb

import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsTable
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsTasksMessagesTable
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsTasksTable
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsUsersTable

object ListsDatabase
{
    //DATABASE VARS
    const val DATABASE_VERSION: Int = 1
    const val DATABASE_NAME: String = "LISTS_DB.db"

    fun createListsTable(): String
    {return ListsTable.CREATE_TABLE}

    fun deleteListsTable(): String
    {return  ListsTable.DELETE_TABLE}

    fun createListsUsersTable(): String
    {return ListsUsersTable.CREATE_TABLE}

    fun deleteListsUsersTable(): String
    {return  ListsUsersTable.DELETE_TABLE}

    fun createListsTasksTable(): String
    {return ListsTasksTable.CREATE_TABLE}

    fun deleteListsTasksTable(): String
    {return  ListsTasksTable.DELETE_TABLE}

    fun createListsTasksMessagesTable(): String
    {return ListsTasksMessagesTable.CREATE_TABLE}

    fun deleteListsTasksMessagesTable(): String
    {return  ListsTasksMessagesTable.DELETE_TABLE}
}