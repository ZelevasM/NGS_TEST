package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models

import com.google.gson.annotations.SerializedName

data class TaskMessageWeb(
    @field:SerializedName("remove_file")
    val removeFile: Boolean? = null,

    @field:SerializedName("read")
    val read: Boolean? = null,

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("user_id")
    val userId: String? = null,

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("files")
    val files: List<TaskMessageFileWeb?>? = null,

    @field:SerializedName("reply")
    val reply: TaskMessageReplyWeb? = null)
{}