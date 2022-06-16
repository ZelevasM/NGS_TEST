package com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatsWeb.Mappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatsWeb.Models.ChatMessageWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatsWeb.Models.ChatUserWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatsWeb.Models.ChatWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.Chat
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.ChatMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.ChatUser
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class ChatMapper: DoubleMapper<Chat?, ChatWeb?>
{
    override fun mapFromTToK(value: Chat?): ChatWeb?
    {
        val messages: ArrayList<ChatMessageWeb?>? = ArrayList()
        if(value?.messages != null)
        {
            for (i in value.messages)
            {
                messages?.add(ChatMessageMapper().mapFromTToK(i))
            }
        }
        val users: ArrayList<ChatUserWeb?>? = ArrayList()
        if(value?.users != null)
        {
            for(i in value.users)
            {
                users?.add(ChatUserMapper().mapFromTToK(i))
            }
        }
        return ChatWeb(id = value?.id, name = value?.name, auth = value?.auth, date = value?.date, color = value?.color,
        projectId = value?.projectId, V = value?.V, messages = messages, users = users)
    }

    override fun mapFromKTOT(value: ChatWeb?): Chat?
    {
        val messages: ArrayList<ChatMessage?>? = ArrayList()
        if(value?.messages != null)
        {
            for (i in value.messages)
            {
                messages?.add(ChatMessageMapper().mapFromKTOT(i))
            }
        }
        val users: ArrayList<ChatUser?>? = ArrayList()
        if(value?.users != null)
        {
            for(i in value.users)
            {
                users?.add(ChatUserMapper().mapFromKTOT(i))
            }
        }
        return Chat(id = value?.id, name = value?.name, auth = value?.auth, date = value?.date, color = value?.color,
            projectId = value?.projectId, V = value?.V, messages = messages, users = users)
    }
}