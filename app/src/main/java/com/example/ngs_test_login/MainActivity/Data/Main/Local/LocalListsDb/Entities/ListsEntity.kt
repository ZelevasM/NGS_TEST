package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.ListSection
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskUser
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task

@Entity(tableName = "lists_table")
data class ListsEntity(
    @PrimaryKey(autoGenerate = false)
    var id: String,

    var name: String? = null,

    var author: String? = null,

    var date: String? = null,

    var color: String? = null,

    var V: Int? = null,

    var order: Int? = null,

    var orderBy: String? = null,

    var users: ArrayList<TaskUser?>? = null,

    var sections: ArrayList<ListSection?>? = null,

    var tasks: ArrayList<Task?>? = null)
{}
