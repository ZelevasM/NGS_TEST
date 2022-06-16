package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.TableManagers.*
import com.example.ngs_test_login.MainActivity.Data.User.Models.UserWeb
import com.example.ngs_test_login.MainActivity.Domain.User.DateFormatLocalProviderInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UserLocalProviderInterface

class UsersDatabaseManager (private val context: Context):
    UserLocalProviderInterface, DateFormatLocalProviderInterface
{
    private val usersDatabaseHelper: UsersDatabaseHelper = UsersDatabaseHelper(context)
    private var mDb: SQLiteDatabase? = null

    //TableManagers
    private var usersTableManager: UsersTableManager = UsersTableManager()
    private var usersFoldersTableManager: UsersFoldersTableManager = UsersFoldersTableManager()
    private var usersFoldersListsTableManager: UsersFoldersListsTableManager = UsersFoldersListsTableManager()
    private var usersDatesFormatTableManager: UsersDateFormatsTableManager = UsersDateFormatsTableManager()
    private var usersShortcutsTableManager: UsersShortcutsTableManager = UsersShortcutsTableManager()

    fun openDb(): Boolean
    {
        //TODO SUPER MEGA GOVNO CODE -> CHANGE IT
        var newlyCreated: Boolean = true
        mDb = usersDatabaseHelper.writableDatabase

        if(mDb != null){newlyCreated = false}
        Log.d("LocalDb", "DB NEW: $newlyCreated")
        return newlyCreated
    }

    fun writeToDb(userWeb: UserWeb?)
    {
        usersDatabaseHelper.onUpgrade(mDb,UsersDatabase.DATABASE_VERSION,UsersDatabase.DATABASE_VERSION)
        usersTableManager.write(userWeb, mDb)
        usersFoldersTableManager.write(userWeb, mDb)
        usersFoldersListsTableManager.write(userWeb, mDb)
        usersDatesFormatTableManager.write(userWeb, mDb)
        usersShortcutsTableManager.write(userWeb, mDb)
    }

    @SuppressLint("Range")
    fun readFromDb(): UserWeb?
    {
        var userWeb: UserWeb? = usersTableManager.read(mDb)
        userWeb = usersFoldersTableManager.read(userWeb, mDb)
        userWeb = usersFoldersListsTableManager.read(userWeb, mDb)
        userWeb = usersDatesFormatTableManager.read(userWeb, mDb)
        userWeb = usersShortcutsTableManager.read(userWeb, mDb)
        return userWeb
    }

    fun closeDb()
    {
        //close db helper
        usersDatabaseHelper.close()
    }

    //USER SETTINGS
    override fun saveName(vararg userWeb: UserWeb?,db: SQLiteDatabase?,name: String?)
    {
        usersTableManager.saveName(db=mDb, userWeb = userWeb, name = name)
    }

    override fun getName(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getName(db = mDb, userWeb = userWeb)
    }


    override fun saveEmail(vararg userWeb: UserWeb?,db: SQLiteDatabase?,email: String?)
    {
        usersTableManager.saveEmail(db=mDb, userWeb = userWeb, email = email)
    }

    override fun getEmail(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getEmail(db = mDb, userWeb = userWeb)
    }

    //USER GENERAL SETTINGS

    override fun saveLanguage(vararg userWeb: UserWeb?,db: SQLiteDatabase?,language: String?)
    {
        usersTableManager.saveLanguage(db=mDb, userWeb = userWeb, language = language)
    }

    override fun getLanguage(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getLanguage(db = mDb, userWeb = userWeb)
    }

    override fun saveHomepage(vararg userWeb: UserWeb?,db: SQLiteDatabase?,homepage: String?)
    {
        usersTableManager.saveHomepage(db=mDb, userWeb = userWeb, homepage = homepage)
    }

    override fun getHomepage(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
       return usersTableManager.getHomepage(db = mDb, userWeb = userWeb)
    }

    override fun saveDateFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?,dateFormat: String?)
    {
        usersDatesFormatTableManager.saveDateFormat(db= mDb, userWeb = userWeb, dateFormat = dateFormat)
    }

    override fun getDateFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersDatesFormatTableManager.getDateFormat(db= mDb, userWeb = userWeb)
    }

    override fun saveTimeFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?,timeFormat: String?)
    {
        usersDatesFormatTableManager.saveTimeFormat(db= mDb, userWeb = userWeb, timeFormat = timeFormat)
    }

    override fun getTimeFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersDatesFormatTableManager.getTimeFormat(db =mDb, userWeb = userWeb)
    }

    override fun saveStartOfWeek(vararg userWeb: UserWeb?,db: SQLiteDatabase?,startOfWeek: String?)
    {
        usersDatesFormatTableManager.saveStartOfWeek(db = mDb, userWeb = userWeb, startOfWeek = startOfWeek)
    }

    override fun getStartOfWeek(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersDatesFormatTableManager.getStartOfWeek(db= mDb, userWeb = userWeb)
    }

    override fun saveExpandSubtask(vararg userWeb: UserWeb?,db: SQLiteDatabase?,expandSubtask: String?)
    {
        usersTableManager.saveExpandSubtask(db=mDb, userWeb = userWeb, expandSubtask = expandSubtask)
    }

    override fun getExpandSubtask(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getExpandSubtask(db = mDb, userWeb = userWeb)
    }

    override fun saveNewTask(vararg userWeb: UserWeb?,db: SQLiteDatabase?,newTask: String?)
    {
        usersTableManager.saveNewTask(db=mDb, userWeb = userWeb, newTask = newTask)
    }

    override fun getNewTask(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getNewTask(db = mDb, userWeb = userWeb)
    }


    //IRRELEVANT

    override fun saveShortcutInbox(vararg userWeb: UserWeb?,db: SQLiteDatabase?)
    {
        TODO("Not yet implemented")
    }

    override fun getShortcutInbox(vararg userWeb: UserWeb?)
    {
        usersTableManager.getShortcutInbox(userWeb = userWeb)
    }

    override fun saveId(vararg userWeb: UserWeb?,db: SQLiteDatabase?)
    {
        TODO("Not yet implemented")
    }

    override fun getId(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getId(db = mDb, userWeb = userWeb)
    }

    override fun saveShowSidebar(vararg userWeb: UserWeb?,db: SQLiteDatabase?,sidebar: String?)
    {
        usersTableManager.saveShowSidebar(db=mDb, userWeb = userWeb, sidebar = sidebar)
    }

    override fun getShowSidebar(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getShowSidebar(db = mDb, userWeb = userWeb)
    }

    override fun saveDiskSpace(vararg userWeb: UserWeb?,db: SQLiteDatabase?,diskSpace: String?)
    {
        usersTableManager.saveDiskSpace(db=mDb, userWeb = userWeb, diskSpace= diskSpace)
    }

    override fun getDiskSpace(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getDiskSpace(db = mDb, userWeb = userWeb)
    }
}