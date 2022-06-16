package com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatsWeb.Models

import com.google.gson.annotations.SerializedName

data class SocketSendChat(
    @SerializedName("chat_name") val name: String,
    @SerializedName("chat_id") val id: String)
{}