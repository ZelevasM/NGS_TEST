package com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks

import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut


interface UserShortcutsSocketCallbackInterface
{
    fun onChanged(shortcuts: ArrayList<Shortcut?>?)
}