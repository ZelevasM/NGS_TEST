package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksSocketModels

import com.google.gson.annotations.SerializedName

data class SocketSendTaskSecondWeb(
    @SerializedName("task_id") val task_id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("project_id") val projectId: String? = null,
    @SerializedName("parent") val parent: String? = null,
    @SerializedName("done") val done: Boolean? = null,
    @SerializedName("notes") val notes: String? = null,
    @SerializedName("out") val out: Boolean? = null,
    @SerializedName("new_order") val newOrder: String? = null)
{}