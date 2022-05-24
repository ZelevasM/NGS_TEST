package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDatabaseHelper(context: Context): SQLiteOpenHelper(context,UserDatabase.DATABASE_NAME,
                    null,UserDatabase.DATABASE_VERSION)
{
    override fun onCreate(db: SQLiteDatabase?)
    {
        db?.execSQL(UserDatabase.createUserTable())
        db?.execSQL(UserDatabase.createFoldersTable())
        db?.execSQL(UserDatabase.createFoldersListsTable())
    }

    override fun onUpgrade(db: SQLiteDatabase?,oldVersion: Int,newVersion: Int)
    {
        db?.execSQL(UserDatabase.deleteUserTable())
        db?.execSQL(UserDatabase.deleteFoldersTable())
        db?.execSQL(UserDatabase.deleteFoldersListsTable())
        onCreate(db)
    }
}