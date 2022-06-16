package com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatsWeb.Mappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatsWeb.Models.ChatMessageWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.ChatMessage
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class ChatMessageMapper: DoubleMapper<ChatMessage?, ChatMessageWeb?>
{
    override fun mapFromTToK(value: ChatMessage?): ChatMessageWeb?
    {
        return ChatMessageWeb(id = value?.id, userId = value?.userId, date = value?.date, read = value?.read, files = value?.files, reply = value?.reply, message = value?.message)
    }

    override fun mapFromKTOT(value: ChatMessageWeb?): ChatMessage?
    {
        return ChatMessage(id = value?.id, userId = value?.userId, date = value?.date, read = value?.read, files = value?.files, reply = value?.reply, message = value?.message)
    }
}