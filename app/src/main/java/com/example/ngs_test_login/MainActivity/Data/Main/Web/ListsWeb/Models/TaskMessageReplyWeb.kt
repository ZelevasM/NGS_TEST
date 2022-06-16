package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models

import com.google.gson.annotations.SerializedName

data class TaskMessageReplyWeb(
    @field:SerializedName("files")
    val files: List<TaskMessageFileWeb?>? = null)
{}