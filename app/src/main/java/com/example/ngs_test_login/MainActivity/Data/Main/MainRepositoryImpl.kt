package com.example.ngs_test_login.MainActivity.Data.Main

import android.content.Context
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.ChatsDao
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.ChatsDatabase
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.ListsDao
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.ListsDatabase
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ChatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.Chat
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import io.socket.client.Socket

class MainRepositoryImpl: MainRepository
{
    //lateinit then + init fun
    private lateinit var mSocket: Socket

    //Local DB
    private var listsRepositoryImpl: ListsRepositoryImpl? = null
    private var chatRepositoryImpl: ChatRepositoryImpl? = null
    private var listsDao: ListsDao? = null
    private var chatsDao: ChatsDao? = null

    //Local Database's Methods

    override fun localDbInit(context: Context)
    {
        listsDao = ListsDatabase.getDatabase(context).listsDao()
        listsRepositoryImpl = ListsRepositoryImpl(listsDao!!)

        chatsDao = ChatsDatabase.getDatabase(context).chatsDao()
        chatRepositoryImpl = ChatRepositoryImpl(chatsDao!!)
    }

    override fun localDbClose()
    {
        ListsDatabase.closeDatabase()
        ChatsDatabase.closeDatabase()
    }

    //Local Database's Methods For Lists

    override fun addLocalLists(dataLists: ArrayList<DataList?>?)
    {
        listsRepositoryImpl?.addLocalLists(dataLists)
    }

    override fun getLocalLists(): ArrayList<DataList?>?
    {
        return listsRepositoryImpl?.getLocalLists()
    }

    override fun addLocalList(dataList: DataList)
    {
        listsRepositoryImpl?.addLocalList(dataList)
    }

    override fun updateLocalList(dataList: DataList)
    {
        listsRepositoryImpl?.updateLocalList(dataList)
    }

    override fun deleteLocalList(dataList: DataList)
    {
        listsRepositoryImpl?.deleteLocalList(dataList)
    }

    override fun getLocalList(dataList: DataList): DataList?
    {
        return listsRepositoryImpl?.getLocalList(dataList)
    }

    //Local Database's Methods For Chats

    override fun addLocalChats(chats: ArrayList<Chat?>?)
    {
        chatRepositoryImpl?.addLocalChats(chats)
    }

    override fun getLocalChats(): ArrayList<Chat?>?
    {
        return chatRepositoryImpl?.getLocalChats()
    }

    override fun addLocalChat()
    {
        chatRepositoryImpl?.addLocalChat()
    }

    override fun updateLocalChat()
    {
        chatRepositoryImpl?.updateChat()
    }

    override fun deleteLocalChat()
    {
        chatRepositoryImpl?.deleteLocalChat()
    }

    override fun getLocalChat()
    {
        chatRepositoryImpl?.getLocalChat()
    }

    //Socket's Methods

    override fun socketInit(bSocket: Socket)
    {
        mSocket = bSocket
        listsRepositoryImpl?.socketInit(mSocket)
        chatRepositoryImpl?.socketInit(mSocket)
    }

    //Socket's Methods For Lists

    override fun addList(name: String)
    {
        listsRepositoryImpl?.addList(name)
    }

    override fun updateList(id: String,newName: String)
    {
        listsRepositoryImpl?.updateList(id, newName)
    }

    override fun deleteList(id: String)
    {
        listsRepositoryImpl?.deleteList(id)
    }

    override fun getList(listSocketCallbackInterface: ListSocketCallbackInterface)
    {
        listsRepositoryImpl?.getList(listSocketCallbackInterface)
    }

    //Socket's Methods For Chats

    override fun addChat(name: String)
    {
        chatRepositoryImpl?.addChat(name)
    }

    override fun updateChat()
    {
        chatRepositoryImpl?.updateChat()
    }

    override fun deleteChat()
    {
        chatRepositoryImpl?.deleteChat()
    }

    override fun getChat(chatSocketCallbackInterface: ChatSocketCallbackInterface)
    {
        chatRepositoryImpl?.getChat(chatSocketCallbackInterface)
    }
}