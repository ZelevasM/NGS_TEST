package com.example.ngs_test_login.MainActivity.Data.Main

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.ChatsDatabaseManager
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.ListsDatabaseManager
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatSocket
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListSocket
import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ChatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.Chat
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList
import io.socket.client.Socket

class MainInterfaceImpl: MainInterface
{
    //lateinit then + init fun
    private lateinit var mSocket: Socket
    private lateinit var listSocket: ListSocket
    private lateinit var chatSocket: ChatSocket

    //Local DB
    private var dataLists: ArrayList<DataList?>? = ArrayList()
    private var chats: ArrayList<DataList?>? = ArrayList()
    private var listsDatabaseManager: ListsDatabaseManager? = null
    private var chatsDatabaseManager: ChatsDatabaseManager? = null

    override fun socketInit(bSocket: Socket)
    {
        mSocket = bSocket
        listSocket = ListSocket(mSocket)
        chatSocket = ChatSocket(mSocket)
    }

    override fun localDbInit(context: Context)
    {
        listsDatabaseManager = ListsDatabaseManager(context)
        listsDatabaseManager?.openDb()
        chatsDatabaseManager = ChatsDatabaseManager(context)
        chatsDatabaseManager?.openDb()
    }

    override fun localDbClose()
    {
        listsDatabaseManager?.closeDb()
        chatsDatabaseManager?.closeDb()
    }

    override fun addLocalLists(dataLists: ArrayList<DataList?>?)
    {
        listsDatabaseManager?.writeToDb(dataLists)
    }

    override fun getLocalLists(): ArrayList<DataList?>?
    {
        dataLists = listsDatabaseManager?.readFromDb()
        return dataLists
    }

    override fun addLocalChats(chats: ArrayList<Chat?>?)
    {
        chatsDatabaseManager?.writeToDb(chats)
    }

    override fun getLocalChats(): ArrayList<Chat?>?
    {
        return chatsDatabaseManager?.readFromDb()
    }

    override fun addLocalList(dataList: DataList)
    {
        listsDatabaseManager?.addLocalList(dataList, dataLists)
    }

    override fun updateLocalList(dataList: DataList)
    {
        listsDatabaseManager?.updateLocalList(dataList, dataLists)
    }

    override fun deleteLocalList(dataList: DataList)
    {
        listsDatabaseManager?.deleteLocalList(dataList, dataLists)
    }

    override fun getLocalList(dataList: DataList)
    {
        listsDatabaseManager?.getLocalList(dataList, dataLists)
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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun addList(name: String)
    {
        listSocket.addList(name)
    }

    override fun updateList(id: String,newName: String)
    {
        listSocket.updateList(id, newName)
    }

    override fun deleteList(id: String)
    {
        listSocket.deleteList(id)
    }

    override fun getList(listSocketCallbackInterface: ListSocketCallbackInterface)
    {
        listSocket.getList(listSocketCallbackInterface)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun addChat(name: String)
    {
        chatSocket.addChat(name)
    }

    override fun getChat(chatSocketCallbackInterface: ChatSocketCallbackInterface)
    {
        chatSocket.getChat(chatSocketCallbackInterface)
    }
}