package com.example.ngs_test_login.MainActivity.Domain.User.Models

data class User(
    var id: String? = null,

    var name: String? = null,

    var email: String? = null,

    var shortcutInbox: String? = null,

    var language: String? = null,

    var diskSpace: String? = null,

    var showSidebar: Boolean? = null,

    var expandSubtask: Boolean? = null,

    var newTask: Boolean? = null,

    var token: ArrayList<Any?>? = null,

    var dateFormatWeb: DateFormat? = null,

    var homepage: Homepage? = null,

    var shortcuts: ArrayList<Shortcut?>? = null,

    var folders: ArrayList<Folder?>? = null)
{}