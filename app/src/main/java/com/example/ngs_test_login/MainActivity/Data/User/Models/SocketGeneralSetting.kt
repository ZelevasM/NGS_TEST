package com.example.ngs_test_login.MainActivity.Data.User.Models

import com.google.gson.annotations.SerializedName

data class SocketGeneralSetting(
    @SerializedName("type") val type: String?  =null,
    @SerializedName("field") val field: Boolean?  = null)
{}