package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksChatsSocketModels

import com.google.gson.annotations.SerializedName

data class SocketTaskMessageWeb
    (
    @SerializedName("_id") val id: String? = null,
    @SerializedName("task_id") val taskId: String? = null,
    @SerializedName("project_id") val projectId: String? = null,
    @SerializedName("message") val message: String? = null,
    @SerializedName("all_read") val allRead: Boolean? = null,
    @SerializedName("replyChatId") val replyChatId: String? = null,
    @SerializedName("file_id") val fileId: String? = null,
    @SerializedName("date") val date: String? = null,
    @SerializedName("user_name") val userName: String? = null,
    @SerializedName("user_image") val userImage: String? = null,
    @SerializedName("user_id") val userId: String? = null,
    @SerializedName("reply") val reply: String? = null,
    @SerializedName("remove_file") val removeFile: String? = null,
    @SerializedName("chats") val chat: SocketTaskMessageWeb? = null)