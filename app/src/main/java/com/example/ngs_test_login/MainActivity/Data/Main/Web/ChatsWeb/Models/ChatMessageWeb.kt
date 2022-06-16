package com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatsWeb.Models

import com.google.gson.annotations.SerializedName

data class ChatMessageWeb(
    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("user_id")
    val userId: String? = null,

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("read")
    val read: Boolean? = null,

    @field:SerializedName("files")
    val files: ArrayList<Any?>? = ArrayList(),

    @field:SerializedName("reply")
    val reply: String? = null,

    @field:SerializedName("message")
    val message: String? = null)
{}