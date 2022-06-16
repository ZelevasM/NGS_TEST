package com.example.ngs_test_login.MainActivity.Data.User.Models

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.FolderWeb
import com.google.gson.annotations.SerializedName

data class UserWeb(
    @field:SerializedName("shortcut_inbox")
    var shortcutInbox: String? = null,

    @field:SerializedName("shortcuts")
    var shortcutWebs: List<ShortcutWeb?>? = null,

    @field:SerializedName("language")
    var language: String? = null,

    @field:SerializedName("disk_space")
    var diskSpace: String? = null,

    @field:SerializedName("show_sidebar")
    var showSidebar: Boolean? = null,

    @field:SerializedName("token")
    var token: List<Any?>? = null,

    @field:SerializedName("folder")
    var folderWeb: List<FolderWeb?>? = null,

    @field:SerializedName("expand_subtask")
    var expandSubtask: Boolean? = null,

    @field:SerializedName("name")
    var name: String? = null,

    @field:SerializedName("date_format")
    var dateFormatWeb: DateFormatWeb? = null,

    @field:SerializedName("_id")
    var id: String? = null,

    @field:SerializedName("new_task")
    var newTask: Boolean? = null,

    @field:SerializedName("email")
    var email: String? = null,

    @field:SerializedName("homepage")
    var homepage: HomepageWeb? = null)
{}
