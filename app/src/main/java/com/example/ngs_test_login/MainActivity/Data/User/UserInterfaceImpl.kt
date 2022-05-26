package com.example.ngs_test_login.MainActivity.Data.User

import android.content.Context
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.UserDatabaseManager
import com.example.ngs_test_login.MainActivity.Data.Base.Web.BaseSocket
import com.example.ngs_test_login.MainActivity.Data.User.Web.UserSocket
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UserLocalDbProviderInterface
import io.socket.client.Socket

class UserInterfaceImpl: UserInterface
{
    private lateinit var mSocket: Socket
    //Local DB
    private var userDatabaseManager: UserDatabaseManager? = null

    override fun socketInit()
    {
        TODO("Not yet implemented")
    }

    override fun localDbInit(context: Context)
    {
        //userDatabaseManager = UserDatabaseManager.getInstance(context)
        userDatabaseManager = UserDatabaseManager(context)
        val newlyCreated: Boolean? = userDatabaseManager?.openDb()
    }

    override fun localDbClose()
    {
        userDatabaseManager?.closeDb()
    }

    override fun addLocalUser(context: Context, user: User?)
    {
        //test db
        userDatabaseManager?.writeToDb(user)
    }

    override fun getLocalUser(): User?
    {
        val user: User? = userDatabaseManager?.readFromDb()
        return user
    }

    override fun changeName()
    {

        val userSocket: UserSocket = UserSocket(mSocket)
        userSocket.changeName()
        userSocket.onChangedName()
    }

    override fun changeEmail()
    {
        val userSocket: UserSocket = UserSocket(mSocket)
        userSocket.changeEmail()
        userSocket.onChangedEmail()
    }

    override fun changePassword()
    {
        val userSocket: UserSocket = UserSocket(mSocket)
        userSocket.changePassword()
        userSocket.onChangedPassword()
    }

    override fun changeHomepage()
    {
        val userSocket: UserSocket = UserSocket(mSocket)
        userSocket.changeHomepage()
        userSocket.onChangedHomepage()
    }

    override fun changeDateFormat()
    {
        //mSocket = BaseSocket().initialize()
        val userSocket: UserSocket = UserSocket(mSocket)
        userSocket.changeDateFormat()
        userSocket.onChangedDateFormat()
    }

    override fun changeTimeFormat()
    {
        val userSocket: UserSocket = UserSocket(mSocket)
        userSocket.changeTimeFormat()
        userSocket.onChangedTimeFormat()
    }

    override fun changeStartOfWeek()
    {
        val userSocket: UserSocket = UserSocket(mSocket)
        userSocket.changeStartOfWeek()
        userSocket.onChangedStartOfWeek()
    }

    override fun changeExpandSubtask()
    {
        val userSocket: UserSocket = UserSocket(mSocket)
        userSocket.changeExpandSubtask()
        userSocket.onChangedExpandSubtask()
    }

    override fun changeNewTask()
    {
        val userSocket: UserSocket = UserSocket(mSocket)
        userSocket.changeNewTask()
        userSocket.onChangedNewTask()
    }
}