package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class Task(
    @field:SerializedName("assign")
    var assign: TaskAssign? = null,

    @field:SerializedName("done")
    var done: Boolean? = null,

    @field:SerializedName("_id")
    var id: String? = null,

    @field:SerializedName("notes")
    var notes: String? = null,

    @field:SerializedName("name")
    var name: String? = null,

    @field:SerializedName("order")
    var order: Int? = null,

    @field:SerializedName("auth")
    var auth: String? = null,

    @field:SerializedName("users")
    var users: List<ListUser?>? = null,

    @field:SerializedName("parent")
    var parent: String? = null,

    @field:SerializedName("date")
    var date: String? = null,

    @field:SerializedName("messages")
    var messages: ArrayList<TaskMessage?>? = null,

    @field:SerializedName("section")
    var section: String? = null,

    @field:SerializedName("priority")
    var priority: String? = null)
{}