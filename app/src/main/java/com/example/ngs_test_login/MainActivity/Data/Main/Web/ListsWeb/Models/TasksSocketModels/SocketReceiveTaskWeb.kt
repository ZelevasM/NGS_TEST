package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksSocketModels

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskAssignWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskUserWeb
import com.google.gson.annotations.SerializedName

data class SocketReceiveTaskWeb(
    @SerializedName("_id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("project_id") val projectId: String? = null,
    @SerializedName("parent") val parent: String? = null,
    @SerializedName("done") val done: Boolean? = null,
    @SerializedName("notes") val notes: String? = null,
    @SerializedName("date") val date: String? = null,
    @SerializedName("auth_id") val auth_id: String? = null,
    @SerializedName("assign") val assign: TaskAssignWeb? = null,
    @SerializedName("order") val order: Int? = null,
    @SerializedName("users") val users: ArrayList<TaskUserWeb?>? = null)
{}