package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.Chat
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class GetLocalChatsUseCase(private val mainRepository: MainRepository)
{
    fun execute(): ArrayList<Chat?>?
    {
        return mainRepository.getLocalChats()
    }
}