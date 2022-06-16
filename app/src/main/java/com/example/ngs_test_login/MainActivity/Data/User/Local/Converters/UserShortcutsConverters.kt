package com.example.ngs_test_login.MainActivity.Data.User.Local.Converters

import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut
import com.google.gson.Gson

class UserShortcutsConverters
{
    fun fromShortcuts(shortcuts: ArrayList<Shortcut?>?): String?
    {
        return Gson().toJson(shortcuts)
    }

    fun toShortcuts(shortcuts: String?): ArrayList<Shortcut?>?
    {
        return Gson().fromJson(shortcuts, Array<Shortcut>::class.java).toList() as ArrayList<Shortcut?>?
    }
}