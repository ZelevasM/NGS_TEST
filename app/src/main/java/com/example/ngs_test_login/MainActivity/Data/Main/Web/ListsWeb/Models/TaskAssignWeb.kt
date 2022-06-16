package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models

import com.google.gson.annotations.SerializedName

data class TaskAssignWeb(
    @field:SerializedName("user_id")
    val userId: String? = null,

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("notif")
    val notif: Boolean? = null,

    @field:SerializedName("remind")
    val remind: String? = null)
{}