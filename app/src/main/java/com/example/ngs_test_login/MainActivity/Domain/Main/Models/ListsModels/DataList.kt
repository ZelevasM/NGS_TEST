package com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels

data class DataList(
    var id: String,

    var name: String? = null,

    var date: String? = null,

    var author: String? = null,

    var color: String? = null,

    var V: Int? = null,

    var orderBy: String? = null,

    var order: Int? = null,

    var users: ArrayList<TaskUser?>? = ArrayList(),

    var sections: ArrayList<ListSection?>? = ArrayList(),

    var tasks: ArrayList<Task?>? = ArrayList())
{}