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
        TODO("Not yet implemented")
    }

    override fun getLocalUser(): User?
    {
        TODO("Not yet implemented")
    }

    //-User Info Repository

    override fun saveLocalName(name: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalName(): String?
    {
        TODO("Not yet implemented")
    }

    override fun saveLocalEmail(email: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalEmail(): String?
    {
        TODO("Not yet implemented")
    }

    //-General Settings Repository

    override fun saveLocalLanguage(language: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalLanguage(): String?
    {
        TODO("Not yet implemented")
    }

    override fun saveLocalHomepage(homepage: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalHomepage(): String?
    {
        TODO("Not yet implemented")
    }

    override fun saveLocalExpandSubtask(expandSubtask: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalExpandSubtask(): String?
    {
        TODO("Not yet implemented")
    }

    override fun saveLocalNewTask(newTask: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalNewTask(): String?
    {
        TODO("Not yet implemented")
    }

    //-Date Format Repository

    override fun saveLocalDateFormat(dateFormat: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalDateFormat(): String?
    {
        TODO("Not yet implemented")
    }

    override fun saveLocalTimeFormat(timeFormat: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalTimeFormat(): String?
    {
        TODO("Not yet implemented")
    }

    override fun saveLocalStartOfWeek(startOfWeek: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalStartOfWeek(): String?
    {
        TODO("Not yet implemented")
    }

    //-Shortcuts' Repository

    override fun updateLocalShortcut()
    {
        TODO("Not yet implemented")
    }

    override fun getLocalShortcut()
    {
        TODO("Not yet implemented")
    }

    //Socket's Methods

    override fun socketInit(bSocket: Socket)
    {
        mSocket = bSocket
        userSocket = UserSocket(mSocket)
    }

    //-User Info Repository Socket's Methods

    override fun changeName(name: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedName(userNameSocketCallbackInterface: UserNameSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }

    override fun changeEmail(email: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedEmail(userEmailSocketCallbackInterface: UserEmailSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }

    override fun changePassword()
    {
        TODO("Not yet implemented")
    }

    override fun onChangedPassword(userPassSocketCallbackInterface: UserPasswordSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }

    //-User General Repository Socket's Methods


    override fun changeHomepage(homepage: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedHomepage(userHomeSocketCallbackInterface: UserHomepageSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }

    override fun changeExpandSubtask(expandSubtask: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedExpandSubtask(userSubtaskSocketCallbackInterface: UserSubtaskSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }

    override fun changeNewTask(newTask: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedNewTask(userNewTaskSocketCallbackInterface: UserNewTaskSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }

    //-Date Format Repository Socket's Methods

    override fun changeDateFormat(dateFormat: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedDateFormat(userDateFormatSocketCallbackInterface: UserDateFormatSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }

    override fun changeTimeFormat(timeFormat: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedTimeFormat(userTimeFormatSocketCallbackInterface: UserTimeFormatSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }

    override fun changeStartOfWeek(startOfWeek: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedStartOfWeek(userStartOfWeekSocketCallbackInterface: UserStartOfWeekSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }

    //-Shortcuts' Repository Socket's Methods

    override fun changeShortcut(shortcuts: ArrayList<Shortcut?>?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedShortcut(userShortcutsSocketCallbackInterface: UserShortcutsSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }
}