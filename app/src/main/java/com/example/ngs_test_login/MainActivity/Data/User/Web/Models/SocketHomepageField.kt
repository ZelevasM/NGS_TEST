package com.example.ngs_test_login.MainActivity.Data.User.Web.Models

import com.google.gson.annotations.SerializedName

data class SocketHomepageField(
    @SerializedName("type") val type: String?  =null,
    @SerializedName("_id") val id: String?  =null)
{}