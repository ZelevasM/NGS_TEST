package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UsersDatabaseHelper(context: Context): SQLiteOpenHelper(context,UsersDatabase.DATABASE_NAME,
                    null,UsersDatabase.DATABASE_VERSION)
{
    override fun onCreate(db: SQLiteDatabase?)
    {
        db?.execSQL(UsersDatabase.createUserTable())
        db?.execSQL(UsersDatabase.createFoldersTable())
        db?.execSQL(UsersDatabase.createFoldersListsTable())
        db?.execSQL(UsersDatabase.createDateFormatsTable())
        db?.execSQL(UsersDatabase.createShortcutsTable())
    }

    override fun onUpgrade(db: SQLiteDatabase?,oldVersion: Int,newVersion: Int)
    {
        db?.execSQL(UsersDatabase.deleteUserTable())
        db?.execSQL(UsersDatabase.deleteFoldersTable())
        db?.execSQL(UsersDatabase.deleteFoldersListsTable())
        db?.execSQL(UsersDatabase.deleteDateFormatsTable())
        db?.execSQL(UsersDatabase.deleteShortcutsTable())
        onCreate(db)
    }
}