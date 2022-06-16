package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models

import com.google.gson.annotations.SerializedName

data class SocketListWeb(
    @SerializedName("name") val name: String,
    @SerializedName("_id") val id: String,
    @SerializedName("order") val order: Int)
{}