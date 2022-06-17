package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Converters

import androidx.room.TypeConverter
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.ChatUser
import com.google.gson.Gson

class ChatsUsersConverters
{
    @TypeConverter
    fun fromChatUsers(chatUsers: ArrayList<ChatUser?>?): String?
    {
        return Gson().toJson(chatUsers)
    }

    @TypeConverter
    fun toChatUsers(chatUsers: String?): ArrayList<ChatUser?>?
    {
        return ArrayList(Gson().fromJson(chatUsers, Array<ChatUser>::class.java).toList())
    }
}