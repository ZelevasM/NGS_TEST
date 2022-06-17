package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Converters

import androidx.room.TypeConverter
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.ChatMessage
import com.google.gson.Gson

class ChatsMessagesConverters
{
    @TypeConverter
    fun fromChatMessages(chatMessages: ArrayList<ChatMessage?>?): String?
    {
        return Gson().toJson(chatMessages)
    }

    @TypeConverter
    fun toChatMessages(chatMessages: String?): ArrayList<ChatMessage?>?
    {
        return ArrayList(Gson().fromJson(chatMessages, Array<ChatMessage>::class.java).toList())
    }
}