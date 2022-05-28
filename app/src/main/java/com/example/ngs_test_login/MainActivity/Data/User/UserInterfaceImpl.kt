package com.example.ngs_test_login.MainActivity.Data.User

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.UsersDatabaseManager
import com.example.ngs_test_login.MainActivity.Data.User.Web.UserSocket
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.*
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UserLocalProviderInterface
import io.socket.client.Socket

class UserInterfaceImpl: UserInterface
{
    private lateinit var mSocket: Socket
    private lateinit var userSocket: UserSocket
    //Local DB
    private var usersDatabaseManager: UsersDatabaseManager? = null
    private var mUser: User? = null

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

    override fun addLocalUser(user: User?)
    {
        //test db
        usersDatabaseManager?.writeToDb(user)
    }

    override fun getLocalUser(): User?
    {
        mUser = usersDatabaseManager?.readFromDb()
        return mUser
    }

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

    //USER SETTINGS

    override fun saveName(vararg user: User?,db: SQLiteDatabase?,name: String?)
    {
        usersDatabaseManager?.saveName(mUser,db=null,name = name)
    }

    override fun getName(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getName(mUser, db = null)
    }

    override fun saveEmail(vararg user: User?,db: SQLiteDatabase?,email: String?)
    {
        usersDatabaseManager?.saveEmail(mUser,db=null,email = email)
    }

    override fun getEmail(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getEmail(mUser, db = null)
    }

    //USER GENERAL SETTINGS

    override fun saveLanguage(vararg user: User?,db: SQLiteDatabase?,language: String?)
    {
        usersDatabaseManager?.saveLanguage(mUser,db=null,language = language)
    }

    override fun getLanguage(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getLanguage(mUser, db = null)
    }

    override fun saveHomepage(vararg user: User?,db: SQLiteDatabase?,homepage: String?)
    {
        usersDatabaseManager?.saveHomepage(mUser,db = null, homepage = homepage)
    }

    override fun getHomepage(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getHomepage(mUser,db = null)
    }

    override fun saveDateFormat(vararg user: User?,db: SQLiteDatabase?,dateFormat: String?)
    {
        usersDatabaseManager?.saveDateFormat(mUser,db=null,dateFormat = dateFormat)
    }

    override fun getDateFormat(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getDateFormat(mUser,db=null)
    }

    override fun saveTimeFormat(vararg user: User?,db: SQLiteDatabase?,timeFormat: String?)
    {
        usersDatabaseManager?.saveTimeFormat(mUser,db = null, timeFormat = timeFormat)
    }

    override fun getTimeFormat(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getTimeFormat(mUser,db = null)
    }

    override fun saveStartOfWeek(vararg user: User?,db: SQLiteDatabase?,startOfWeek: String?)
    {
        usersDatabaseManager?.saveStartOfWeek(mUser,db = null, startOfWeek = startOfWeek)
    }

    override fun getStartOfWeek(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getStartOfWeek(mUser,db = null)
    }

    override fun saveExpandSubtask(vararg user: User?,db: SQLiteDatabase?,expandSubtask: String?)
    {
        usersDatabaseManager?.saveExpandSubtask(mUser,db=null,expandSubtask = expandSubtask)
    }

    override fun getExpandSubtask(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getExpandSubtask(mUser, db = null)
    }

    override fun saveNewTask(vararg user: User?,db: SQLiteDatabase?,newTask: String?)
    {
        usersDatabaseManager?.saveNewTask(mUser,db=null,newTask = newTask)
    }

    override fun getNewTask(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getNewTask(mUser, db = null)
    }


    //IRRELEVANT

    override fun saveShortcutInbox(vararg user: User?,db: SQLiteDatabase?)
    {
        TODO("Not yet implemented")
    }

    override fun getShortcutInbox(vararg user: User?)
    {
        usersDatabaseManager?.getShortcutInbox(mUser)
    }

    override fun saveId(vararg user: User?,db: SQLiteDatabase?)
    {
        TODO("Not yet implemented")
    }

    override fun getId(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getId(mUser, db = null)
    }

    override fun saveShowSidebar(vararg user: User?,db: SQLiteDatabase?,sidebar: String?)
    {
        usersDatabaseManager?.saveShowSidebar(mUser,db=null,sidebar= sidebar)
    }

    override fun getShowSidebar(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getShowSidebar(mUser, db = null)
    }

    override fun saveDiskSpace(vararg user: User?,db: SQLiteDatabase?,diskSpace: String?)
    {
        usersDatabaseManager?.saveDiskSpace(mUser,db=null,diskSpace= diskSpace)
    }

    override fun getDiskSpace(vararg user: User?,db: SQLiteDatabase?): String?
    {
        return usersDatabaseManager?.getDiskSpace(mUser, db = null)
    }
}