package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb

import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Tables.ChatsMessagesTable
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Tables.ChatsTable
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsTable
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsTasksMessagesTable
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsTasksTable
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsUsersTable

object ChatsDatabase
{
    //DATABASE VARS
    const val DATABASE_VERSION: Int = 1
    const val DATABASE_NAME: String = "CHATS_DB.db"

    fun createChatsTable(): String
    {return ChatsTable.CREATE_TABLE}

    fun deleteChatsTable(): String
    {return ChatsTable.DELETE_TABLE}

    fun createChatsMessagesTable(): String
    {return ChatsMessagesTable.CREATE_TABLE}

    fun deleteChatsMessagesTable(): String
    {return ChatsMessagesTable.DELETE_TABLE}
}