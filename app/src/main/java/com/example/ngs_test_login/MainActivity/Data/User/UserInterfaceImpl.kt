package com.example.ngs_test_login.MainActivity.Data.User

import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Main.Web.MainSocket
import com.example.ngs_test_login.MainActivity.Data.User.Web.UserSocket
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface
import io.socket.client.Socket

class UserInterfaceImpl: UserInterface
{
    //*DELETE*//
    private lateinit var mSocket: Socket
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
        mSocket = MainSocket().initialize()
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