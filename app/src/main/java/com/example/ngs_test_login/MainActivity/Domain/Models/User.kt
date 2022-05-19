package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class User(
    @field:SerializedName("shortcut_inbox")
    var shortcutInbox: String? = null,

    @field:SerializedName("shortcuts")
    var shortcuts: List<Shortcut?>? = null,

    @field:SerializedName("language")
    var language: String? = null,

    @field:SerializedName("disk_space")
    var diskSpace: String? = null,

    @field:SerializedName("show_sidebar")
    var showSidebar: Boolean? = null,

    @field:SerializedName("token")
    var token: List<Any?>? = null,

    @field:SerializedName("folder")
    var folder: List<Folder?>? = null,

    @field:SerializedName("expand_subtask")
    var expandSubtask: Boolean? = null,

    @field:SerializedName("name")
    var name: String? = null,

    @field:SerializedName("date_format")
    var dateFormat: DateFormat? = null,

    @field:SerializedName("_id")
    var id: String? = null,

    @field:SerializedName("new_task")
    var newTask: Boolean? = null,

    @field:SerializedName("email")
    var email: String? = null,

    @field:SerializedName("homepage")
    var homepage: HomePage? = null)
{

}
