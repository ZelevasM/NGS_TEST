package com.example.ngs_test_login.MainActivity.Data.User.Web.Models

import com.google.gson.annotations.SerializedName

data class SocketShortcuts(
    @SerializedName("shortcuts")
    val shortcutWebs: ArrayList<ShortcutWeb> = ArrayList())
{}