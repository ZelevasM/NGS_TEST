package com.example.ngs_test_login.MainActivity.Data.User

import com.example.ngs_test_login.MainActivity.Data.User.Local.UserDao
import com.example.ngs_test_login.MainActivity.Data.User.Web.UserSocket
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.ShortcutsRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserShortcutsSocketCallbackInterface
import io.socket.client.Socket

class ShortcutsRepositoryImpl(private val userDao: UserDao): ShortcutsRepository
{
    private lateinit var userSocket: UserSocket
    override fun updateLocalShortcut()
    {
        TODO()
    }

    override fun getLocalShortcut()
    {
        TODO("Not yet implemented")
    }

    //Socket's Methods

    override fun socketInit(bSocket: Socket)
    {
        userSocket = UserSocket(bSocket)
    }

    override fun changeShortcut(shortcuts: ArrayList<Shortcut?>?)
    {
        userSocket.changeShortcut(shortcuts)
    }

    override fun onChangedShortcut(userShortcutsSocketCallbackInterface: UserShortcutsSocketCallbackInterface)
    {
        userSocket.onChangedShortcut(userShortcutsSocketCallbackInterface)
    }
}