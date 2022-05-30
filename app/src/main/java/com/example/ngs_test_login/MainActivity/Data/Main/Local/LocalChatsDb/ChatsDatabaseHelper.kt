package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ChatsDatabaseHelper(context: Context): SQLiteOpenHelper(context, ChatsDatabase.DATABASE_NAME,
                                                                null, ChatsDatabase.DATABASE_VERSION)
{
    override fun onCreate(db: SQLiteDatabase?)
    {
        db?.execSQL(ChatsDatabase.createChatsTable())
        db?.execSQL(ChatsDatabase.createChatsMessagesTable())
    }

    override fun onUpgrade(db: SQLiteDatabase?,oldVersion: Int,newVersion: Int)
    {
        db?.execSQL(ChatsDatabase.deleteChatsTable())
        db?.execSQL(ChatsDatabase.deleteChatsMessagesTable())
        onCreate(db)
    }
}