package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Converters

import androidx.room.TypeConverter
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.ListSection
import com.google.gson.Gson

class ListsSectionsConverters
{
    @TypeConverter
    fun fromListsSections(listsSections: ArrayList<ListSection?>?): String?
    {
        return Gson().toJson(listsSections)
    }

    @TypeConverter
    fun toListsSections(listsSections: String?): ArrayList<ListSection?>?
    {
        return Gson().fromJson(listsSections, Array<ListSection>::class.java).toList() as ArrayList<ListSection?>?
    }
}