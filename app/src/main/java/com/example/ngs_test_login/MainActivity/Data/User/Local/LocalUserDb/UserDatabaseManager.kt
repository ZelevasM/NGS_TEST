package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.TableManagers.FoldersListsTableManager
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.TableManagers.FoldersTableManager
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.TableManagers.UserTableManager
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.UserLocalDbProviderInterface

class UserDatabaseManager (private val context: Context): UserLocalDbProviderInterface
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

    override fun saveName()
    {
        TODO("Not yet implemented")
    }

    override fun getName()
    {
        TODO("Not yet implemented")
    }

    override fun saveId()
    {
        TODO("Not yet implemented")
    }

    override fun getId()
    {
        TODO("Not yet implemented")
    }

    override fun saveEmail()
    {
        TODO("Not yet implemented")
    }

    override fun getEmail()
    {
        TODO("Not yet implemented")
    }

    override fun saveLanguage()
    {
        TODO("Not yet implemented")
    }

    override fun getLanguage()
    {
        TODO("Not yet implemented")
    }

    override fun saveShowSidebar()
    {
        TODO("Not yet implemented")
    }

    override fun getShowSidebar()
    {
        TODO("Not yet implemented")
    }

    override fun saveDiskSpace()
    {
        TODO("Not yet implemented")
    }

    override fun getDiskSpace()
    {
        TODO("Not yet implemented")
    }

    override fun saveExpandSubtask()
    {
        TODO("Not yet implemented")
    }

    override fun getExpandSubtask()
    {
        TODO("Not yet implemented")
    }

    override fun saveNewTask()
    {
        TODO("Not yet implemented")
    }

    override fun getNewTask()
    {
        TODO("Not yet implemented")
    }

    override fun saveShortcutInbox()
    {
        TODO("Not yet implemented")
    }

    override fun getShortcutInbox()
    {
        TODO("Not yet implemented")
    }
}