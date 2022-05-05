package com.example.ngs_test_login.MainActivity.Domain.Main

import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ChatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.MainData

interface MainInterface
{
    fun getData(): MainData

    fun socketInit()

    fun addList(name: String)

    fun getList(listSocketCallbackInterface: ListSocketCallbackInterface)

    fun addChat(name: String)

    fun getChat(chatSocketCallbackInterface: ChatSocketCallbackInterface)
}