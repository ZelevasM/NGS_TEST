package com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatsWeb.Mappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatsWeb.Models.ChatUserWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.ChatUser
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class ChatUserMapper: DoubleMapper<ChatUser?, ChatUserWeb?>
{
    override fun mapFromTToK(value: ChatUser?): ChatUserWeb?
    {
        return ChatUserWeb(userId = value?.userId, unreadNumber = value?.unreadNumber, read = value?.read, readLastMessage = value?.readLastMessage)
    }

    override fun mapFromKTOT(value: ChatUserWeb?): ChatUser?
    {
        return ChatUser(userId = value?.userId, unreadNumber = value?.unreadNumber, read = value?.read, readLastMessage = value?.readLastMessage)
    }
}