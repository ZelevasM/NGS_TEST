package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models

import com.google.gson.annotations.SerializedName

data class TaskWeb(
    @field:SerializedName("_id")
    var id: String? = null,

    @field:SerializedName("name")
    var name: String? = null,

    @field:SerializedName("priority")
    var priority: String? = null,

    @field:SerializedName("done")
    var done: Boolean? = null,

    @field:SerializedName("date")
    var date: String? = null,

    @field:SerializedName("order")
    var order: Int? = null,

    @field:SerializedName("auth")
    var auth: String? = null,

    @field:SerializedName("notes")
    var notes: String? = null,

    @field:SerializedName("parent")
    var parent: String? = null,

    @field:SerializedName("section")
    var section: String? = null,

    @field:SerializedName("assign")
    var assign: TaskAssignWeb? = null,

    @field:SerializedName("users")
    var users: List<TaskUserWeb?>? = null,

    @field:SerializedName("messages")
    var messages: ArrayList<TaskMessageWeb?>? = null,)
{}