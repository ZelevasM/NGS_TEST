package com.example.ngs_test_login.MainActivity.Data.User.Web.Models

import com.google.gson.annotations.SerializedName

data class SocketName(
    @SerializedName("type") val type: String? = null,
    @SerializedName("name") val name: String? = null)
{}