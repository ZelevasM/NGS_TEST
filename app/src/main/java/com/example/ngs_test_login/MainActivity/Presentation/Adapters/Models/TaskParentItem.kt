package com.example.ngs_test_login.MainActivity.Presentation.Adapters.Models

import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskAssign
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskUser

data class TaskParentItem(
    var id: String? = null,

    var name: String? = null,

    var priority: String? = null,

    var isExpanded: Boolean? = null,

    var auth: String? = null,

    var done: Boolean? = null,

    var section: String? = null,

    var notes: String? = null,

    var order: Int? = null,

    var date: String? = null,

    var assign: TaskAssign? = null,

    var childTasks: ArrayList<TaskChildItem?>? = null,

    var messages: ArrayList<TaskMessage?>? = null,

    var users: List<TaskUser?>? = null)
{}