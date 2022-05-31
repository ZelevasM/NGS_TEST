package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class Chat(
    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("auth")
    val auth: String? = null,

    @field:SerializedName("color")
    val color: String? = null,

    @field:SerializedName("project_id")
    val projectId: String? = null,

    @field:SerializedName("__v")
    val V: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("messages")
    var messages: ArrayList<ChatMessage?>? = ArrayList(),

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("users")
    val users: ArrayList<ListUser?>? = ArrayList())
{}

