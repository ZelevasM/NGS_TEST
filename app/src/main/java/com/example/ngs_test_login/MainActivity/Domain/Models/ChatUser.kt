package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class ChatUser(

    @field:SerializedName("read_last_message")
    val readLastMessage: String? = null,

    @field:SerializedName("unread_number")
    val unreadNumber: String? = null,

    @field:SerializedName("read")
    val read: Boolean? = null,

    @field:SerializedName("user_id")
    val userId: String? = null)
{}