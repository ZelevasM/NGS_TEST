package com.example.ngs_test_login.MainActivity.Domain.Main.Repositories

import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ChatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.Chat
import io.socket.client.Socket

interface ChatsRepository
{
    fun addLocalChats(chats: ArrayList<Chat?>?)

    fun getLocalChats(): ArrayList<Chat?>?

    fun addLocalChat()

    fun updateLocalChat()

    fun deleteLocalChat()

    fun getLocalChat()

    //Socket's Methods

    fun socketInit(bSocket: Socket)

    fun addChat(name: String)

    fun updateChat()

    fun deleteChat()

    fun getChat(chatSocketCallbackInterface: ChatSocketCallbackInterface)
}