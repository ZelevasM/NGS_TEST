package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.UsersDatabase

class ListsDatabaseHelper(context: Context): SQLiteOpenHelper(context, ListsDatabase.DATABASE_NAME,
                                                            null, ListsDatabase.DATABASE_VERSION)
{
    override fun onCreate(db: SQLiteDatabase?)
    {
        db?.execSQL(ListsDatabase.createListsTable())
        db?.execSQL(ListsDatabase.createListsUsersTable())
        db?.execSQL(ListsDatabase.createListsTasksTable())
        db?.execSQL(ListsDatabase.createListsTasksMessagesTable())
    }

    override fun onUpgrade(db: SQLiteDatabase?,oldVersion: Int,newVersion: Int)
    {
        db?.execSQL(ListsDatabase.deleteListsTable())
        db?.execSQL(ListsDatabase.deleteListsUsersTable())
        db?.execSQL(ListsDatabase.deleteListsTasksTable())
        db?.execSQL(ListsDatabase.deleteListsTasksMessagesTable())
        onCreate(db)
    }
}