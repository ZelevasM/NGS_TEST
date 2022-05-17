package com.example.ngs_test_login.MainActivity.Domain.Main

import android.content.Context
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ChatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.MainData
import com.example.ngs_test_login.MainActivity.Domain.Models.User

interface MainInterface
{
    fun getData(): MainData

    fun socketInit()

    fun addList(name: String)

    fun getList(listSocketCallbackInterface: ListSocketCallbackInterface)

    fun addChat(name: String)

    fun getChat(chatSocketCallbackInterface: ChatSocketCallbackInterface)

    fun localDbInit(context: Context): Boolean?

    fun localDbClose()

    fun addLocalUser(context: Context, user: User?)

    fun getLocalUser()
}