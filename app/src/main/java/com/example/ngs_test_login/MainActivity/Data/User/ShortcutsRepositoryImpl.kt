package com.example.ngs_test_login.MainActivity.Data.User

import com.example.ngs_test_login.MainActivity.Data.User.Local.UserDao
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.ShortcutsRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserShortcutsSocketCallbackInterface

class ShortcutsRepositoryImpl(private val userDao: UserDao): ShortcutsRepository
{
    override fun updateLocalShortcut()
    {
        TODO("Not yet implemented")
    }

    override fun getLocalShortcut()
    {
        TODO("Not yet implemented")
    }

    //Socket's Methods

    override fun changeShortcut(shortcuts: ArrayList<Shortcut?>?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedShortcut(userShortcutsSocketCallbackInterface: UserShortcutsSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }
}