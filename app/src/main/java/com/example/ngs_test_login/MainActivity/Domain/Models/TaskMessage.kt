package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class TaskMessage(
    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("read")
    val read: Boolean? = null,

    @field:SerializedName("user_id")
    val userId: String? = null,

    @field:SerializedName("files")
    val files: List<Any?>? = null,

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("reply")
    val reply: TaskMessageReply? = null,

    @field:SerializedName("message")
    val message: String? = null)
{}