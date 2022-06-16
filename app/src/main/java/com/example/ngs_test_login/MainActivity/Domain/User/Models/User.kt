package com.example.ngs_test_login.MainActivity.Domain.User.Models

import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Folder

data class User(
    var id: String? = null,

    var name: String? = null,

    var email: String? = null,

    var shortcutInbox: String? = null,

    var shortcutWebs: List<Shortcut?>? = null,

    var language: String? = null,

    var diskSpace: String? = null,

    var showSidebar: Boolean? = null,

    var token: List<Any?>? = null,

    var folderWeb: List<Folder?>? = null,

    var expandSubtask: Boolean? = null,

    var dateFormatWeb: DateFormat? = null,

    var newTask: Boolean? = null,

    var homepage: Homepage? = null)
{}