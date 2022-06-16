package com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel

data class Chat(
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