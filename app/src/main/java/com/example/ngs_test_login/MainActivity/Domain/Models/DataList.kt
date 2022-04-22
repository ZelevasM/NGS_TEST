package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName
import kotlin.collections.List

data class DataList(
    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("author")
    val author: String? = null,

    @field:SerializedName("__v")
    val V: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("order_by")
    val orderBy: String? = null,

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("users")
    val users: List<ListUser?>? = null,

    @field:SerializedName("sections")
    val sections: List<ListSection?>? = null,

    @field:SerializedName("tasks")
    val tasks: List<Task?>? = null)
{

}
