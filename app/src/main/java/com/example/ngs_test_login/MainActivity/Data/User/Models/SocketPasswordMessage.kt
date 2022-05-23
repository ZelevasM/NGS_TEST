package com.example.ngs_test_login.MainActivity.Data.User.Models

import com.google.gson.annotations.SerializedName

data class SocketPasswordMessage(
    @SerializedName("message") val message: Boolean? = null)
{}