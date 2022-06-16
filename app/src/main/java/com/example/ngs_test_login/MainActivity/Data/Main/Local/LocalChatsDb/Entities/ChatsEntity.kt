package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.ChatMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.ChatUser

@Entity(tableName = "chats_table")
data class ChatsEntity(
    @PrimaryKey(autoGenerate = false)
    var id: String,

    var name: String? = null,

    var auth: String? = null,

    var date: String? = null,

    var color: String? = null,

    var projectId: String? = null,

    var messages: ArrayList<ChatMessage?>? = null,

    var users: ArrayList<ChatUser?>? = null,

    var V: Int? = null)
{}