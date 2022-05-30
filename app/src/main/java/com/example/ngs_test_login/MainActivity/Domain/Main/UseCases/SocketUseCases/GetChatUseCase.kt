package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ChatSocketCallbackInterface

class GetChatUseCase(private val mainInterface: MainInterface)
{
    fun execute(chatSocketCallbackInterface: ChatSocketCallbackInterface)
    {
        mainInterface.getChat(chatSocketCallbackInterface)
    }
}