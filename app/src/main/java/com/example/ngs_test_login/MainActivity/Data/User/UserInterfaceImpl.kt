package com.example.ngs_test_login.MainActivity.Data.User

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.UsersDatabaseManager
import com.example.ngs_test_login.MainActivity.Data.User.Web.UserSocket
import com.example.ngs_test_login.MainActivity.Data.User.Models.ShortcutWeb
import com.example.ngs_test_login.MainActivity.Data.User.Models.UserWeb
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.*
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface
import io.socket.client.Socket

class UserInterfaceImpl: UserInterface
{
    private lateinit var mSocket: Socket
    private lateinit var userSocket: UserSocket
    //Local DB
    private var usersDatabaseManager: UsersDatabaseManager? = null
    private var mUserWeb: UserWeb? = null

    override fun socketInit(bSocket: Socket)
    {
        mSocket = bSocket
        userSocket = UserSocket(mSocket)
    }

    override fun localDbInit(context: Context)
    {
        usersDatabaseManager = UsersDatabaseManager(context)
        val newlyCreated: Boolean? = usersDatabaseManager?.openDb()
    }

    override fun localDbClose()
    {
        usersDatabaseManager?.closeDb()
    }

    override fun addLocalUser(userWeb: UserWeb?)
    {
        //test db
        usersDatabaseManager?.writeToDb(userWeb)
    }

    override fun getLocalUser(): UserWeb?
    {
        mUserWeb = usersDatabaseManager?.readFromDb()
        return mUserWeb
    }

    //USER SETTINGS

    override fun changeName(name: String?)
    {
        userSocket.changeName(name)
    }

    override fun onChangedName(userNameSocketCallbackInterface: UserNameSocketCallbackInterface)
    {
        userSocket.onChangedName(userNameSocketCallbackInterface)
    }

    override fun changeEmail(email: String?)
    {
        userSocket.changeEmail(email)
    }

    override fun onChangedEmail(userEmailSocketCallbackInterface: UserEmailSocketCallbackInterface)
    {
        userSocket.onChangedEmail(userEmailSocketCallbackInterface)
    }

    override fun changePassword()
    {
        userSocket.changePassword()
    }

    override fun onChangedPassword(userPassSocketCallbackInterface: UserPasswordSocketCallbackInterface)
    {
        userSocket.onChangedPassword(userPassSocketCallbackInterface)
    }

    override fun changeHomepage(homepage: String?)
    {
        userSocket.changeHomepage(homepage)
    }

    override fun onChangedHomepage(userHomeSocketCallbackInterface: UserHomepageSocketCallbackInterface)
    {
        userSocket.onChangedHomepage(userHomeSocketCallbackInterface)
    }

    override fun changeDateFormat(dateFormat: String?)
    {
        userSocket.changeDateFormat(dateFormat)
    }

    override fun onChangedDateFormat(userDateFormatSocketCallbackInterface: UserDateFormatSocketCallbackInterface)
    {
        userSocket.onChangedDateFormat(userDateFormatSocketCallbackInterface)
    }

    override fun changeTimeFormat(timeFormat: String?)
    {
        userSocket.changeTimeFormat(timeFormat)
    }

    override fun onChangedTimeFormat(userTimeFormatSocketCallbackInterface: UserTimeFormatSocketCallbackInterface)
    {
        userSocket.onChangedTimeFormat(userTimeFormatSocketCallbackInterface)
    }

    override fun changeStartOfWeek(startOfWeek: String?)
    {
        userSocket.changeStartOfWeek(startOfWeek)
    }

    override fun onChangedStartOfWeek(userStartOfWeekSocketCallbackInterface: UserStartOfWeekSocketCallbackInterface)
    {
        userSocket.onChangedStartOfWeek(userStartOfWeekSocketCallbackInterface)
    }

    override fun changeExpandSubtask(expandSubtask: String?)
    {
        userSocket.changeExpandSubtask(expandSubtask)
    }

    override fun onChangedExpandSubtask(userSubtaskSocketCallbackInterface: UserSubtaskSocketCallbackInterface)
    {
        userSocket.onChangedExpandSubtask(userSubtaskSocketCallbackInterface)
    }

    override fun changeNewTask(newTask: String?)
    {
        userSocket.changeNewTask(newTask)
    }

    override fun onChangedNewTask(userNewTaskSocketCallbackInterface: UserNewTaskSocketCallbackInterface)
    {
        userSocket.onChangedNewTask(userNewTaskSocketCallbackInterface)
    }

    override fun changeShortcut(shortcutWebs: ArrayList<ShortcutWeb?>?)
    {
        userSocket.changeShortcut(shortcutWebs)
    }

    override fun onChangedShortcut(userShortcutsSocketCallbackInterface: UserShortcutsSocketCallbackInterface)
    {
       userSocket.onChangedShortcut(userShortcutsSocketCallbackInterface)
    }

    //USER LOCAL SETTINGS

    override fun saveName(vararg userWeb: UserWeb?,db: SQLiteDatabase?,name: String?)
    {
        usersDatabaseManager?.saveName(mUserWeb,db=null,name = name)
    }

    override fun getName(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getName(mUserWeb, db = null)
    }

    override fun saveEmail(vararg userWeb: UserWeb?,db: SQLiteDatabase?,email: String?)
    {
        usersDatabaseManager?.saveEmail(mUserWeb,db=null,email = email)
    }

    override fun getEmail(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getEmail(mUserWeb, db = null)
    }

    //USER LOCAL GENERAL SETTINGS

    override fun saveLanguage(vararg userWeb: UserWeb?,db: SQLiteDatabase?,language: String?)
    {
        usersDatabaseManager?.saveLanguage(mUserWeb,db=null,language = language)
    }

    override fun getLanguage(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getLanguage(mUserWeb, db = null)
    }

    override fun saveHomepage(vararg userWeb: UserWeb?,db: SQLiteDatabase?,homepage: String?)
    {
        usersDatabaseManager?.saveHomepage(mUserWeb,db = null, homepage = homepage)
    }

    override fun getHomepage(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getHomepage(mUserWeb,db = null)
    }

    override fun saveDateFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?,dateFormat: String?)
    {
        usersDatabaseManager?.saveDateFormat(mUserWeb,db=null,dateFormat = dateFormat)
    }

    override fun getDateFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getDateFormat(mUserWeb,db=null)
    }

    override fun saveTimeFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?,timeFormat: String?)
    {
        usersDatabaseManager?.saveTimeFormat(mUserWeb,db = null, timeFormat = timeFormat)
    }

    override fun getTimeFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getTimeFormat(mUserWeb,db = null)
    }

    override fun saveStartOfWeek(vararg userWeb: UserWeb?,db: SQLiteDatabase?,startOfWeek: String?)
    {
        usersDatabaseManager?.saveStartOfWeek(mUserWeb,db = null, startOfWeek = startOfWeek)
    }

    override fun getStartOfWeek(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getStartOfWeek(mUserWeb,db = null)
    }

    override fun saveExpandSubtask(vararg userWeb: UserWeb?,db: SQLiteDatabase?,expandSubtask: String?)
    {
        usersDatabaseManager?.saveExpandSubtask(mUserWeb,db=null,expandSubtask = expandSubtask)
    }

    override fun getExpandSubtask(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getExpandSubtask(mUserWeb, db = null)
    }

    override fun saveNewTask(vararg userWeb: UserWeb?,db: SQLiteDatabase?,newTask: String?)
    {
        usersDatabaseManager?.saveNewTask(mUserWeb,db=null,newTask = newTask)
    }

    override fun getNewTask(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getNewTask(mUserWeb, db = null)
    }

    //IRRELEVANT LOCAL

    override fun saveShortcutInbox(vararg userWeb: UserWeb?,db: SQLiteDatabase?)
    {
        TODO("Not yet implemented")
    }

    override fun getShortcutInbox(vararg userWeb: UserWeb?)
    {
        usersDatabaseManager?.getShortcutInbox(mUserWeb)
    }

    override fun saveId(vararg userWeb: UserWeb?,db: SQLiteDatabase?)
    {
        TODO("Not yet implemented")
    }

    override fun getId(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getId(mUserWeb, db = null)
    }

    override fun saveShowSidebar(vararg userWeb: UserWeb?,db: SQLiteDatabase?,sidebar: String?)
    {
        usersDatabaseManager?.saveShowSidebar(mUserWeb,db=null,sidebar= sidebar)
    }

    override fun getShowSidebar(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getShowSidebar(mUserWeb, db = null)
    }

    override fun saveDiskSpace(vararg userWeb: UserWeb?,db: SQLiteDatabase?,diskSpace: String?)
    {
        usersDatabaseManager?.saveDiskSpace(mUserWeb,db=null,diskSpace= diskSpace)
    }

    override fun getDiskSpace(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getDiskSpace(mUserWeb, db = null)
    }
}