package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ChatSocketCallbackInterface

class GetChatUseCase(private val mainRepository: MainRepository)
{
    fun execute(chatSocketCallbackInterface: ChatSocketCallbackInterface)
    {
        mainRepository.getChat(chatSocketCallbackInterface)
    }
}