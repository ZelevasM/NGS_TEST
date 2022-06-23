package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksSocketModels

import com.google.gson.annotations.SerializedName

data class SocketSendTaskWeb(
    @SerializedName("_id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("project_id") val projectId: String? = null,
    @SerializedName("parent") val parent: String? = null,
    @SerializedName("done") val done: Boolean? = null,
    @SerializedName("notes") val notes: String? = null,
    @SerializedName("out") val out: Boolean? = null,
    @SerializedName("assign") val assign: String? = null,
    @SerializedName("remind") val remind: String? = null,
    @SerializedName("date") val date: String? = null,
    @SerializedName("user_id") val userId: String? = null,
    @SerializedName("new_order") val newOrder: String? = null)
{}