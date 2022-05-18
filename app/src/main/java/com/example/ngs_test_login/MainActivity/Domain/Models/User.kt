package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class User(
    @field:SerializedName("shortcut_inbox")
    val shortcutInbox: String? = null,

    @field:SerializedName("shortcuts")
    val shortcuts: List<Shortcut?>? = null,

    @field:SerializedName("language")
    val language: String? = null,

    @field:SerializedName("disk_space")
    val diskSpace: String? = null,

    @field:SerializedName("show_sidebar")
    val showSidebar: Boolean? = null,

    @field:SerializedName("token")
    val token: List<Any?>? = null,

    @field:SerializedName("folder")
    val folder: List<Folder?>? = null,

    @field:SerializedName("expand_subtask")
    val expandSubtask: Boolean? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("date_format")
    val dateFormat: DateFormat? = null,

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("new_task")
    val newTask: Boolean? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("homepage")
    val homepage: HomePage? = null)
{

}
