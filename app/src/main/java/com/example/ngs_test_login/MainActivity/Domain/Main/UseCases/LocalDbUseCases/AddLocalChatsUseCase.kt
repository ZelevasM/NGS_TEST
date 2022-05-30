package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.Chat

class AddLocalChatsUseCase(private val mainInterface: MainInterface)
{
    fun execute(chats: ArrayList<Chat?>?)
    {
        mainInterface.addLocalChats(chats)
    }
}