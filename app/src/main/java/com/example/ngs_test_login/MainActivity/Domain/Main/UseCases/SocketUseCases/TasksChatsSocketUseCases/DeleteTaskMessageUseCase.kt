package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksChatsSocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class DeleteTaskMessageUseCase(private val mainRepository: MainRepository)
{
    fun execute(id: String?, taskId: String?)
    {
        mainRepository.deleteTaskMessage(id, taskId)
    }
}