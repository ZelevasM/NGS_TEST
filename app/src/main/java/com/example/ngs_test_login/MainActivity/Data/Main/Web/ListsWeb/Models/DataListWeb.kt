package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models

import com.google.gson.annotations.SerializedName

data class DataListWeb(
    @field:SerializedName("_id")
    var id: String? = null,

    @field:SerializedName("name")
    var name: String? = null,

    @field:SerializedName("date")
    var date: String? = null,

    @field:SerializedName("author")
    var author: String? = null,

    @field:SerializedName("color")
    var color: String? = null,

    @field:SerializedName("__v")
    var V: Int? = null,

    @field:SerializedName("order_by")
    var orderBy: String? = null,

    @field:SerializedName("order")
    var order: Int? = null,

    @field:SerializedName("users")
    var users: ArrayList<TaskUserWeb?>? = ArrayList(),

    @field:SerializedName("sections")
    var sections: ArrayList<ListSectionWeb?>? = ArrayList(),

    @field:SerializedName("tasks")
    var tasks: ArrayList<TaskWeb?>? = ArrayList())
{}
