package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class SocketChat(
    @SerializedName("chat_name") val name: String,
    @SerializedName("chat_id") val id: String)
{}