package com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels

data class TaskMessage(
    val id: String? = null,

    val userId: String? = null,

    val read: Boolean? = null,

    val date: String? = null,

    val message: String? = null,

    val removeFile: Boolean? = null,

    val reply: TaskMessageReply? = null,

    val files: List<TaskMessageFile?>? = null)
{}