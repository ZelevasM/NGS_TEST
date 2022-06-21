package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksChatsSocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class ReadTaskMessageUseCase(private val mainRepository: MainRepository)
{
    fun execute(id: String?, taskId: String?, userId: String?, allRead: Boolean?)
    {
        mainRepository.readTaskMessage(id, taskId, userId, allRead)
    }
}