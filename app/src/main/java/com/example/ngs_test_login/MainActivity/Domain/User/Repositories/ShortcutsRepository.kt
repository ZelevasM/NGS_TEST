package com.example.ngs_test_login.MainActivity.Domain.User.Repositories

import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserShortcutsSocketCallbackInterface
import io.socket.client.Socket

interface ShortcutsRepository
{
    fun updateLocalShortcut()

    fun getLocalShortcut()

    //Socket's Methods

    fun socketInit(bSocket: Socket)

    fun changeShortcut(shortcuts: ArrayList<Shortcut?>?)

    fun onChangedShortcut(userShortcutsSocketCallbackInterface: UserShortcutsSocketCallbackInterface)
}