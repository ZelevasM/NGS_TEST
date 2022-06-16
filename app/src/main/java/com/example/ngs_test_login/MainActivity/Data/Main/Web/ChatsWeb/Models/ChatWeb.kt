package com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatsWeb.Models

import com.google.gson.annotations.SerializedName

data class ChatWeb(
    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("auth")
    val auth: String? = null,

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("color")
    val color: String? = null,

    @field:SerializedName("project_id")
    val projectId: String? = null,

    @field:SerializedName("__v")
    val V: Int? = null,

    @field:SerializedName("messages")
    val messages: ArrayList<ChatMessageWeb?>? = ArrayList(),

    @field:SerializedName("users")
    val users: ArrayList<ChatUserWeb?>? = ArrayList())
{}

