package com.example.ngs_test_login.MainActivity.Domain.Main

import android.content.Context
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ChatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.Chat
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList
import com.example.ngs_test_login.MainActivity.Domain.Models.MainData
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import io.socket.client.Socket

interface MainInterface
{
    fun socketInit(bSocket: Socket)

    fun localDbInit(context: Context)

    fun localDbClose()

    fun addLocalLists(dataLists: ArrayList<DataList?>?)

    fun getLocalLists(): ArrayList<DataList?>?

    fun addLocalChats(chats: ArrayList<Chat?>?)

    fun getLocalChats(): ArrayList<Chat?>?

    fun addList(name: String)

    fun getList(listSocketCallbackInterface: ListSocketCallbackInterface)

    fun addChat(name: String)

    fun getChat(chatSocketCallbackInterface: ChatSocketCallbackInterface)
}