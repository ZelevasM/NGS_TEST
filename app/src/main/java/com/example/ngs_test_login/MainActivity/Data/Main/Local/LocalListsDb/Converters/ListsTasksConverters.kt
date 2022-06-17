package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Converters

import androidx.room.TypeConverter
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.google.gson.Gson

class ListsTasksConverters
{
    @TypeConverter
    fun fromTasks(tasks: ArrayList<Task?>?): String?
    {
        return Gson().toJson(tasks)
    }

    @TypeConverter
    fun toTasks(tasks: String?): ArrayList<Task?>?
    {
        return ArrayList(Gson().fromJson(tasks, Array<Task>::class.java).toList())
    }
}