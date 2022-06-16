package com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks

import com.example.ngs_test_login.MainActivity.Data.User.Models.ShortcutWeb

interface UserShortcutsSocketCallbackInterface
{
    fun onChanged(shortcutWebs: ArrayList<ShortcutWeb?>?)
}