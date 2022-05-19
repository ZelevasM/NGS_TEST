package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalUserDb

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalUserDb.TableManagers.FoldersListsTableManager
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalUserDb.TableManagers.FoldersTableManager
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalUserDb.TableManagers.UserTableManager
import com.example.ngs_test_login.MainActivity.Domain.Models.User

class UserDatabaseManager (private val context: Context)
{
    private val userDatabaseHelper: UserDatabaseHelper = UserDatabaseHelper(context)
    private var db: SQLiteDatabase? = null

    //TableManagers
    private var userTableManager: UserTableManager = UserTableManager()
    private var foldersTableManager: FoldersTableManager = FoldersTableManager()
    private var foldersListsTableManager: FoldersListsTableManager = FoldersListsTableManager()

    fun openDb(): Boolean
    {
        //TODO SUPER MEGA GOVNO CODE -> CHANGE IT
        var newlyCreated: Boolean = true

        db = userDatabaseHelper.writableDatabase

        if(db != null){newlyCreated = false}
        Log.d("LocalDb", "DB NEW: $newlyCreated")
        return newlyCreated
    }

    fun writeToDb(user: User?)
    {
        userDatabaseHelper.onUpgrade(db,UserDatabase.DATABASE_VERSION,UserDatabase.DATABASE_VERSION)
        userTableManager.write(user, db)
        foldersTableManager.write(user, db)
        foldersListsTableManager.write(user, db)
    }

    @SuppressLint("Range")
    fun readFromDb(): User?
    {
        var user: User? = userTableManager.read(db)
        user = foldersTableManager.read(user, db)
        user = foldersListsTableManager.read(user, db)
        return user
    }

    fun closeDb()
    {
        //close db helper
        userDatabaseHelper.close()
    }
}