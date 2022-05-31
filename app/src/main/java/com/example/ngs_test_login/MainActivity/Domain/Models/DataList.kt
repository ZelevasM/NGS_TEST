package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName
import kotlin.collections.List

data class DataList(
    @field:SerializedName("date")
    var date: String? = null,

    @field:SerializedName("author")
    var author: String? = null,

    @field:SerializedName("color")
    var color: String? = null,

    @field:SerializedName("__v")
    var V: Int? = null,

    @field:SerializedName("name")
    var name: String? = null,

    @field:SerializedName("order_by")
    var orderBy: String? = null,

    @field:SerializedName("order")
    var order: Int? = null,

    @field:SerializedName("_id")
    var id: String? = null,

    @field:SerializedName("users")
    var users: ArrayList<ListUser?>? = ArrayList(),

    @field:SerializedName("sections")
    var sections: ArrayList<ListSection?>? = ArrayList(),

    @field:SerializedName("tasks")
    var tasks: ArrayList<Task?>? = ArrayList())
{

}
