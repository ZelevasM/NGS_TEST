package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.Chat

class GetLocalChatsUseCase(private val mainInterface: MainInterface)
{
    fun execute(): ArrayList<Chat?>?
    {
        return mainInterface.getLocalChats()
    }
}