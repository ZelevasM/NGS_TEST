package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class TaskMessageReply(
    @field:SerializedName("files")
    val files: List<Any?>? = null)
{}