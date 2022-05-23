package com.example.ngs_test_login.MainActivity.Data.User.Models

import com.google.gson.annotations.SerializedName

data class SocketEmail(
    @SerializedName("type") val type: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("password") val password: String? = null)
{}