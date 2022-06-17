package com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels

data class Task(
    var id: String? = null,

    var name: String? = null,

    var priority: String? = null,

    var auth: String? = null,

    var done: Boolean? = null,

    var section: String? = null,

    var notes: String? = null,

    var order: Int? = null,

    var parent: String? = null,

    var date: String? = null,

    var assign: TaskAssign? = null,

    var messages: ArrayList<TaskMessage?>? = null,

    var users: List<TaskUser?>? = null)
{}