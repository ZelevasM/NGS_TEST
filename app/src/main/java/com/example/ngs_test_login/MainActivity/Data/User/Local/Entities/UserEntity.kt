package com.example.ngs_test_login.MainActivity.Data.User.Local.Entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Folder
import com.example.ngs_test_login.MainActivity.Domain.User.Models.DateFormat
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Homepage
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    var id: String,

    var name: String? = null,

    var email: String? = null,

    var shortcutInbox: String? = null,

    var language: String? = null,

    var diskSpace: String? = null,

    var showSidebar: Boolean? = null,

    var expandSubtask: Boolean? = null,

    var newTask: Boolean? = null,

    @Embedded
    var dateFormat: DateFormat? = null,

    @Embedded
    var homepage: Homepage? = null,

    var shortcuts: ArrayList<Shortcut?>? = null,

    var folders: ArrayList<Folder?>? = null)
{}