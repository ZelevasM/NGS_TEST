package com.example.ngs_test_login.MainActivity.Domain.User.Repositories

import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserShortcutsSocketCallbackInterface

interface ShortcutsRepository
{
    fun updateLocalShortcut()

    fun getLocalShortcut()

    //Socket's Methods

    fun changeShortcut(shortcuts: ArrayList<Shortcut?>?)

    fun onChangedShortcut(userShortcutsSocketCallbackInterface: UserShortcutsSocketCallbackInterface)
}