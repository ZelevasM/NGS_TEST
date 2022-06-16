package com.example.ngs_test_login.MainActivity.Data.Main

import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.ChatsDao
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Entities.ChatsEntity
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Mappers.ChatEntityMapper
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatsWeb.Socket.ChatSocket
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.ChatsRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ChatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.Chat
import io.socket.client.Socket

class ChatRepositoryImpl(private val chatsDao: ChatsDao): ChatsRepository
{
    private lateinit var chatSocket: ChatSocket
    private val chatEntityMapper = ChatEntityMapper()

    override fun addLocalChats(chats: ArrayList<Chat?>?)
    {
        val chatEntities: ArrayList<ChatsEntity?>? = ArrayList()
        if(chats != null)
        {
            for(i in chats)
            {chatEntities?.add(chatEntityMapper.mapFromTToK(i))}
            chatsDao.insertAllChats(chatEntities)
        }
    }

    override fun getLocalChats(): ArrayList<Chat?>?
    {
        val chats: ArrayList<Chat?>? = ArrayList()
        if(chatsDao.getAllChats() != null)
        {
            for(i in chatsDao.getAllChats()!!)
            {chats?.add(chatEntityMapper.mapFromKTOT(i))}
        }
        return chats
    }

    override fun addLocalChat()
    {
        TODO("Not yet implemented")
    }

    override fun updateLocalChat()
    {
        TODO("Not yet implemented")
    }

    override fun deleteLocalChat()
    {
        TODO("Not yet implemented")
    }

    override fun getLocalChat()
    {
        TODO("Not yet implemented")
    }

    //Socket's Methods

    override fun socketInit(mSocket: Socket)
    {
        chatSocket = ChatSocket(mSocket)
    }

    override fun addChat(name: String)
    {
        chatSocket.addChat(name)
    }

    override fun updateChat()
    {
        TODO("Not yet implemented")
    }

    override fun deleteChat()
    {
        TODO("Not yet implemented")
    }

    override fun getChat(chatSocketCallbackInterface: ChatSocketCallbackInterface)
    {
        chatSocket.getChat(chatSocketCallbackInterface)
    }

}