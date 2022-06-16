package com.example.ngs_test_login.MainActivity.Domain.Main.Repositories

import android.content.Context
import io.socket.client.Socket

interface MainRepository: ListsRepository, ChatsRepository
{
    fun localDbInit(context: Context)

    fun localDbClose()

    //Sockets' Methods
    override fun socketInit(bSocket: Socket)
}