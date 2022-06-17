package com.example.ngs_test_login.MainActivity.Data.User

import android.content.Context
import androidx.room.Dao
import com.example.ngs_test_login.MainActivity.Data.User.Local.UserDao
import com.example.ngs_test_login.MainActivity.Data.User.Local.UserDatabase
import com.example.ngs_test_login.MainActivity.Data.User.Web.UserSocket
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.User.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.*
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.*
import io.socket.client.Socket

class UserRepositoryImpl: UserRepository
{
    private lateinit var mSocket: Socket
    private lateinit var userSocket: UserSocket
    //Local Db
    private lateinit var userInfoRepositoryImpl: UserInfoRepositoryImpl
    private lateinit var generalSettingsRepositoryImpl: GeneralSettingsRepositoryImpl
    private lateinit var dateFormatRepositoryImpl: DateFormatRepositoryImpl
    private lateinit var shortcutsRepositoryImpl: ShortcutsRepositoryImpl

    private lateinit var userDao: UserDao


    override fun localDbInit(context: Context)
    {
        userDao = UserDatabase.getDatabase(context).userDao()

        userInfoRepositoryImpl = UserInfoRepositoryImpl(userDao)
        generalSettingsRepositoryImpl = GeneralSettingsRepositoryImpl(userDao)
        dateFormatRepositoryImpl = DateFormatRepositoryImpl(userDao)
        shortcutsRepositoryImpl = ShortcutsRepositoryImpl(userDao)
    }

    override fun localDbClose()
    {
        UserDatabase.closeDatabase()
    }

    override fun addLocalUser(user: User?)
    {
        userInfoRepositoryImpl.addUser(user)
    }

    override fun getLocalUser(): User?
    {
        return userInfoRepositoryImpl.getUser()
    }

    //-User Info Repository

    override fun saveLocalName(name: String?)
    {
        userInfoRepositoryImpl.saveLocalName(name)
    }

    override fun getLocalName(): String?
    {
        return userInfoRepositoryImpl.getLocalName()
    }

    override fun saveLocalEmail(email: String?)
    {
        userInfoRepositoryImpl.saveLocalEmail(email)
    }

    override fun getLocalEmail(): String?
    {
        return userInfoRepositoryImpl.getLocalEmail()
    }

    //-General Settings Repository

    override fun saveLocalLanguage(language: String?)
    {
        generalSettingsRepositoryImpl.saveLocalLanguage(language)
    }

    override fun getLocalLanguage(): String?
    {
        return generalSettingsRepositoryImpl.getLocalLanguage()
    }

    override fun saveLocalHomepage(homepage: String?)
    {
        generalSettingsRepositoryImpl.saveLocalHomepage(homepage)
    }

    override fun getLocalHomepage(): String?
    {
        return generalSettingsRepositoryImpl.getLocalHomepage()
    }

    override fun saveLocalExpandSubtask(expandSubtask: String?)
    {
        generalSettingsRepositoryImpl.saveLocalExpandSubtask(expandSubtask)
    }

    override fun getLocalExpandSubtask(): String?
    {
        return generalSettingsRepositoryImpl.getLocalExpandSubtask()
    }

    override fun saveLocalNewTask(newTask: String?)
    {
        generalSettingsRepositoryImpl.saveLocalNewTask(newTask)
    }

    override fun getLocalNewTask(): String?
    {
        return generalSettingsRepositoryImpl.getLocalNewTask()
    }

    //-Date Format Repository

    override fun saveLocalDateFormat(dateFormat: String?)
    {
        dateFormatRepositoryImpl.saveLocalDateFormat(dateFormat)
    }

    override fun getLocalDateFormat(): String?
    {
        return dateFormatRepositoryImpl.getLocalDateFormat()
    }

    override fun saveLocalTimeFormat(timeFormat: String?)
    {
        dateFormatRepositoryImpl.saveLocalTimeFormat(timeFormat)
    }

    override fun getLocalTimeFormat(): String?
    {
        return dateFormatRepositoryImpl.getLocalTimeFormat()
    }

    override fun saveLocalStartOfWeek(startOfWeek: String?)
    {
        dateFormatRepositoryImpl.saveLocalStartOfWeek(startOfWeek)
    }

    override fun getLocalStartOfWeek(): String?
    {
        return dateFormatRepositoryImpl.getLocalStartOfWeek()
    }

    //-Shortcuts' Repository

    override fun updateLocalShortcut()
    {
        shortcutsRepositoryImpl.updateLocalShortcut()
    }

    override fun getLocalShortcut()
    {
        shortcutsRepositoryImpl.getLocalShortcut()
    }

    //Socket's Methods

    override fun socketInit(bSocket: Socket)
    {
        mSocket = bSocket
        userInfoRepositoryImpl.socketInit(bSocket)
        generalSettingsRepositoryImpl.socketInit(bSocket)
        dateFormatRepositoryImpl.socketInit(bSocket)
        shortcutsRepositoryImpl.socketInit(bSocket)
    }

    //-User Info Repository Socket's Methods

    override fun changeName(name: String?)
    {
        userInfoRepositoryImpl.changeName(name)
    }

    override fun onChangedName(userNameSocketCallbackInterface: UserNameSocketCallbackInterface)
    {
        return userInfoRepositoryImpl.onChangedName(userNameSocketCallbackInterface)
    }

    override fun changeEmail(email: String?)
    {
        userInfoRepositoryImpl.changeEmail(email)
    }

    override fun onChangedEmail(userEmailSocketCallbackInterface: UserEmailSocketCallbackInterface)
    {
        return userInfoRepositoryImpl.onChangedEmail(userEmailSocketCallbackInterface)
    }

    override fun changePassword()
    {
        userInfoRepositoryImpl.changePassword()
    }

    override fun onChangedPassword(userPassSocketCallbackInterface: UserPasswordSocketCallbackInterface)
    {
        userInfoRepositoryImpl.onChangedPassword(userPassSocketCallbackInterface)
    }

    //-User General Repository Socket's Methods

    override fun changeHomepage(homepage: String?)
    {
        generalSettingsRepositoryImpl.changeHomepage(homepage)
    }

    override fun onChangedHomepage(userHomeSocketCallbackInterface: UserHomepageSocketCallbackInterface)
    {
        generalSettingsRepositoryImpl.onChangedHomepage(userHomeSocketCallbackInterface)
    }

    override fun changeExpandSubtask(expandSubtask: String?)
    {
        generalSettingsRepositoryImpl.changeExpandSubtask(expandSubtask)
    }

    override fun onChangedExpandSubtask(userSubtaskSocketCallbackInterface: UserSubtaskSocketCallbackInterface)
    {
        generalSettingsRepositoryImpl.onChangedExpandSubtask(userSubtaskSocketCallbackInterface)
    }

    override fun changeNewTask(newTask: String?)
    {
        generalSettingsRepositoryImpl.changeNewTask(newTask)
    }

    override fun onChangedNewTask(userNewTaskSocketCallbackInterface: UserNewTaskSocketCallbackInterface)
    {
        generalSettingsRepositoryImpl.onChangedNewTask(userNewTaskSocketCallbackInterface)
    }

    //-Date Format Repository Socket's Methods

    override fun changeDateFormat(dateFormat: String?)
    {
        dateFormatRepositoryImpl.changeDateFormat(dateFormat)
    }

    override fun onChangedDateFormat(userDateFormatSocketCallbackInterface: UserDateFormatSocketCallbackInterface)
    {
        dateFormatRepositoryImpl.onChangedDateFormat(userDateFormatSocketCallbackInterface)
    }

    override fun changeTimeFormat(timeFormat: String?)
    {
        dateFormatRepositoryImpl.changeTimeFormat(timeFormat)
    }

    override fun onChangedTimeFormat(userTimeFormatSocketCallbackInterface: UserTimeFormatSocketCallbackInterface)
    {
        dateFormatRepositoryImpl.onChangedTimeFormat(userTimeFormatSocketCallbackInterface)
    }

    override fun changeStartOfWeek(startOfWeek: String?)
    {
        dateFormatRepositoryImpl.changeStartOfWeek(startOfWeek)
    }

    override fun onChangedStartOfWeek(userStartOfWeekSocketCallbackInterface: UserStartOfWeekSocketCallbackInterface)
    {
        dateFormatRepositoryImpl.onChangedStartOfWeek(userStartOfWeekSocketCallbackInterface)
    }

    //-Shortcuts' Repository Socket's Methods

    override fun changeShortcut(shortcuts: ArrayList<Shortcut?>?)
    {
        shortcutsRepositoryImpl.changeShortcut(shortcuts)
    }

    override fun onChangedShortcut(userShortcutsSocketCallbackInterface: UserShortcutsSocketCallbackInterface)
    {
        shortcutsRepositoryImpl?.onChangedShortcut(userShortcutsSocketCallbackInterface)
    }
}