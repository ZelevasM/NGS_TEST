package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.ChatMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.ChatUser

@Entity(tableName = "chats_table")
data class ChatsEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,

    val name: String? = null,

    val auth: String? = null,

    val date: String? = null,

    val color: String? = null,

    val projectId: String? = null,

    val messages: ArrayList<ChatMessage?>? = ArrayList(),

    val users: ArrayList<ChatUser?>? = ArrayList(),

    val V: Int? = null)
{}