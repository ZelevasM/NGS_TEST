package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.TableManagers.*
import com.example.ngs_test_login.MainActivity.Domain.Models.User
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

    fun writeToDb(user: User?)
    {
        usersDatabaseHelper.onUpgrade(mDb,UsersDatabase.DATABASE_VERSION,UsersDatabase.DATABASE_VERSION)
        usersTableManager.write(user, mDb)
        usersFoldersTableManager.write(user, mDb)
        usersFoldersListsTableManager.write(user, mDb)
        usersDatesFormatTableManager.write(user, mDb)
        usersShortcutsTableManager.write(user, mDb)
    }

    @SuppressLint("Range")
    fun readFromDb(): User?
    {
        var user: User? = usersTableManager.read(mDb)
        user = usersFoldersTableManager.read(user, mDb)
        user = usersFoldersListsTableManager.read(user, mDb)
        user = usersDatesFormatTableManager.read(user, mDb)
        user = usersShortcutsTableManager.read(user, mDb)
        return user
    }

    fun closeDb()
    {
        //close db helper
        usersDatabaseHelper.close()
    }

    //USER SETTINGS
    override fun saveName(vararg user: User?,db: SQLiteDatabase?,name: String?)
    {
        usersTableManager.saveName(db=mDb, user = user, name = name)
    }

    override fun getName(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getName(db = mDb, user = user)
    }


    override fun saveEmail(vararg user: User?,db: SQLiteDatabase?,email: String?)
    {
        usersTableManager.saveEmail(db=mDb, user = user, email = email)
    }

    override fun getEmail(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getEmail(db = mDb, user = user)
    }

    //USER GENERAL SETTINGS

    override fun saveLanguage(vararg user: User?,db: SQLiteDatabase?,language: String?)
    {
        usersTableManager.saveLanguage(db=mDb, user = user, language = language)
    }

    override fun getLanguage(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getLanguage(db = mDb, user = user)
    }

    override fun saveHomepage(vararg user: User?,db: SQLiteDatabase?,homepage: String?)
    {
        usersTableManager.saveHomepage(db=mDb, user = user, homepage = homepage)
    }

    override fun getHomepage(vararg user: User?,db: SQLiteDatabase?): String?
    {
       return usersTableManager.getHomepage(db = mDb, user = user)
    }

    override fun saveDateFormat(vararg user: User?,db: SQLiteDatabase?,dateFormat: String?)
    {
        usersDatesFormatTableManager.saveDateFormat(db= mDb, user = user, dateFormat = dateFormat)
    }

    override fun getDateFormat(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersDatesFormatTableManager.getDateFormat(db= mDb, user = user)
    }

    override fun saveTimeFormat(vararg user: User?,db: SQLiteDatabase?,timeFormat: String?)
    {
        usersDatesFormatTableManager.saveTimeFormat(db= mDb, user = user, timeFormat = timeFormat)
    }

    override fun getTimeFormat(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersDatesFormatTableManager.getTimeFormat(db =mDb, user = user)
    }

    override fun saveStartOfWeek(vararg user: User?,db: SQLiteDatabase?,startOfWeek: String?)
    {
        usersDatesFormatTableManager.saveStartOfWeek(db = mDb, user = user, startOfWeek = startOfWeek)
    }

    override fun getStartOfWeek(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersDatesFormatTableManager.getStartOfWeek(db= mDb, user = user)
    }

    override fun saveExpandSubtask(vararg user: User?,db: SQLiteDatabase?,expandSubtask: String?)
    {
        usersTableManager.saveExpandSubtask(db=mDb, user = user, expandSubtask = expandSubtask)
    }

    override fun getExpandSubtask(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getExpandSubtask(db = mDb, user = user)
    }

    override fun saveNewTask(vararg user: User?,db: SQLiteDatabase?,newTask: String?)
    {
        usersTableManager.saveNewTask(db=mDb, user = user, newTask = newTask)
    }

    override fun getNewTask(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getNewTask(db = mDb, user = user)
    }


    //IRRELEVANT

    override fun saveShortcutInbox(vararg user: User?,db: SQLiteDatabase?)
    {
        TODO("Not yet implemented")
    }

    override fun getShortcutInbox(vararg user: User?)
    {
        usersTableManager.getShortcutInbox(user = user)
    }

    override fun saveId(vararg user: User?,db: SQLiteDatabase?)
    {
        TODO("Not yet implemented")
    }

    override fun getId(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getId(db = mDb, user = user)
    }

    override fun saveShowSidebar(vararg user: User?,db: SQLiteDatabase?,sidebar: String?)
    {
        usersTableManager.saveShowSidebar(db=mDb, user = user, sidebar = sidebar)
    }

    override fun getShowSidebar(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getShowSidebar(db = mDb, user = user)
    }

    override fun saveDiskSpace(vararg user: User?,db: SQLiteDatabase?,diskSpace: String?)
    {
        usersTableManager.saveDiskSpace(db=mDb, user = user, diskSpace= diskSpace)
    }

    override fun getDiskSpace(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersTableManager.getDiskSpace(db = mDb, user = user)
    }
}