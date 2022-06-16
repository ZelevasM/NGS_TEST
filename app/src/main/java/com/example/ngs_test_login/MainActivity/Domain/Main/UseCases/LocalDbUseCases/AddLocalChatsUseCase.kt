package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.Chat

class AddLocalChatsUseCase(private val mainRepository: MainRepository)
{
    fun execute(chats: ArrayList<Chat?>?)
    {
        mainRepository.addLocalChats(chats)
    }
}