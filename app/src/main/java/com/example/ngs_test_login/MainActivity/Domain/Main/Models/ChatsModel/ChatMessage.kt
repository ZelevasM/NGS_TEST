package com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel

import com.google.gson.annotations.SerializedName

data class ChatMessage(
    val id: String? = null,

    val userId: String? = null,

    val date: String? = null,

    val read: Boolean? = null,

    val files: ArrayList<Any?>? = ArrayList(),

    val reply: String? = null,

    val message: String? = null)
{}