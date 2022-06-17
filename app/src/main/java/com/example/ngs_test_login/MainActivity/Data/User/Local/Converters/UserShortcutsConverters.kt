package com.example.ngs_test_login.MainActivity.Data.User.Local.Converters

import androidx.room.TypeConverter
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut
import com.google.gson.Gson

class UserShortcutsConverters
{
    @TypeConverter
    fun fromShortcuts(shortcuts: ArrayList<Shortcut?>?): String?
    {
        return Gson().toJson(shortcuts)
    }

    @TypeConverter
    fun toShortcuts(shortcuts: String?): ArrayList<Shortcut?>?
    {
        return ArrayList(Gson().fromJson(shortcuts, Array<Shortcut>::class.java).toList())
    }
}