package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models

import com.google.gson.annotations.SerializedName

data class SocketSendList(
    @SerializedName("name") val name: String? = null,
    @SerializedName("_id") val id: String? = null,
    @SerializedName("order") val order: Int? = null)
{}