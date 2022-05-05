package com.example.ngs_test_login.MainActivity.Domain.Main

import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ChatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.MainData

interface MainInterface
{
    fun getData(): MainData

    fun socketInit()

    fun addList()

    fun getList(listSocketCallbackInterface: ListSocketCallbackInterface)

    fun addChat()

    fun getChat(chatSocketCallbackInterface: ChatSocketCallbackInterface)
}