package com.example.ngs_test_login.MainActivity.Data.User.Models

import com.google.gson.annotations.SerializedName

data class SocketShortcut(
    @field:SerializedName("color")
    val color: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("project_id")
    val projectId: String? = null)
{}