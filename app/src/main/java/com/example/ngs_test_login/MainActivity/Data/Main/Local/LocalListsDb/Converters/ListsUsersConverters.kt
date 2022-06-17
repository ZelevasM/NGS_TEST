package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Converters

import androidx.room.TypeConverter
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskUser
import com.google.gson.Gson

class ListsUsersConverters
{
    @TypeConverter
    fun fromListUsers(taskUsers: ArrayList<TaskUser?>?): String?
    {
        return  Gson().toJson(taskUsers)
    }

    @TypeConverter
    fun toListUsers(listUsers: String?): ArrayList<TaskUser?>?
    {
        return ArrayList(Gson().fromJson(listUsers,Array<TaskUser>::class.java).toList())
    }
}