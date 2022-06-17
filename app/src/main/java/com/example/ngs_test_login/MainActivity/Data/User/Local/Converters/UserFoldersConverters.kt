package com.example.ngs_test_login.MainActivity.Data.User.Local.Converters

import androidx.room.TypeConverter
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Folder
import com.google.gson.Gson

class UserFoldersConverters
{
    @TypeConverter
    fun fromUserFolders(folders: ArrayList<Folder?>?): String?
    {
        return Gson().toJson(folders)
    }

    @TypeConverter
    fun toUserFolders(folders: String?): ArrayList<Folder?>?
    {
        return ArrayList(Gson().fromJson(folders, Array<Folder>::class.java).toList())
    }
}