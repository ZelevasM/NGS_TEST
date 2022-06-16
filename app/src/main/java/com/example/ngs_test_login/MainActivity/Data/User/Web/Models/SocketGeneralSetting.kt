package com.example.ngs_test_login.MainActivity.Data.User.Web.Models

import com.google.gson.annotations.SerializedName

data class SocketGeneralSetting <T> (
    @SerializedName("type") val type: String?  =null,
    @SerializedName("field") val field: T?  = null)
{}