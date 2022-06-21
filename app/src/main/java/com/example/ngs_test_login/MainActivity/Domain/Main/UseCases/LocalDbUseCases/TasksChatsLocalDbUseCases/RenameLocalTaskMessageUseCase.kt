package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.TasksChatsLocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class RenameLocalTaskMessageUseCase(private val mainRepository: MainRepository)
{
    fun execute()
    {
        mainRepository.renameLocalTaskMessage()
    }
}