package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class Task(
    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("parent")
    val parent: String? = null,

    @field:SerializedName("notes")
    val notes: String? = null,

    @field:SerializedName("auth")
    val auth: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("messages")
    val messages: List<TaskMessage?>? = null,

    @field:SerializedName("section")
    val section: String? = null,

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("done")
    val done: Boolean? = null,

    @field:SerializedName("users")
    val users: List<ListUser?>? = null,

    @field:SerializedName("assign")
    val assign: TaskAssign? = null,

    @field:SerializedName("order")
    val order: Int? = null,

    @field:SerializedName("priority")
    val priority: String? = null)
{}