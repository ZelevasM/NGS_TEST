package com.example.ngs_test_login.MainActivity.Data.Main.Local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDatabaseHelper(context: Context): SQLiteOpenHelper(context, UserDatabase.DATABASE_NAME,
                    null, UserDatabase.DATABASE_VERSION)
{
    override fun onCreate(db: SQLiteDatabase?)
    {
        db?.execSQL(UserDatabase.CREATE_TABLE)
        db?.execSQL(UserDatabase.FOLDERS_CREATE_TABLE)
        db?.execSQL(UserDatabase.FOLDERS_LISTS_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?,oldVersion: Int,newVersion: Int)
    {
        db?.execSQL(UserDatabase.DELETE_TABLE)
        db?.execSQL(UserDatabase.FOLDERS_DELETE_TABLE)
        db?.execSQL(UserDatabase.FOLDERS_LISTS_DELETE_TABLE)
        onCreate(db)
    }
}