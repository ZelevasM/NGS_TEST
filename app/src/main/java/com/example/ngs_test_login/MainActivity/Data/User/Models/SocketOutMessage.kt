package com.example.ngs_test_login.MainActivity.Data.User.Models

import com.google.gson.annotations.SerializedName

data class SocketOutMessage(
    @SerializedName("key") val key: String? = null,
    @SerializedName("Message") val message: String? = null)
{}