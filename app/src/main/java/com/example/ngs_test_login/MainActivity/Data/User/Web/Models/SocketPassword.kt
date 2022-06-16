package com.example.ngs_test_login.MainActivity.Data.User.Web.Models

import com.google.gson.annotations.SerializedName

data class SocketPassword(
    @SerializedName("type") val type: String? = null,
    @SerializedName("new_password") val newPassword: String? = null,
    @SerializedName("password") val oldPassword: String? = null)
{}