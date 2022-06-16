package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Mappers

import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Entities.ChatsEntity
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.Chat
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class ChatEntityMapper: DoubleMapper<Chat?, ChatsEntity?>
{
    override fun mapFromTToK(value: Chat?): ChatsEntity?
    {
        if(value?.id == null)
            throw Exception("No Id")
        return ChatsEntity(id = value.id, name = value.name, auth = value.auth, date = value.date, color = value.color, projectId = value.projectId,
        messages = value.messages, users = value.users, V = value.V)
    }

    override fun mapFromKTOT(value: ChatsEntity?): Chat?
    {
        return Chat(id = value?.id!!, name = value.name, auth = value.auth, date = value.date, color = value.color, projectId = value.projectId,
            messages = value.messages, users = value.users, V = value.V)
    }
}