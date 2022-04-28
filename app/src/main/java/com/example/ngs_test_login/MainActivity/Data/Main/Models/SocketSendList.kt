package com.example.ngs_test_login.MainActivity.Data.Main.Models

import com.google.gson.annotations.SerializedName

data class SocketSendList(
    @SerializedName("name") val name: String,
    @SerializedName("_id") val id: String,
    @SerializedName("order") val order: Int)
{}