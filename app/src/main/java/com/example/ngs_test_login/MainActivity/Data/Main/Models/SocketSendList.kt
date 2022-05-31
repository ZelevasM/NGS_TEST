package com.example.ngs_test_login.MainActivity.Data.Main.Models

import com.google.gson.annotations.SerializedName

data class SocketSendList(
    @SerializedName("name") val name: String? = null,
    @SerializedName("_id") val id: String? = null,
    @SerializedName("order") val order: Int? = null)
{}