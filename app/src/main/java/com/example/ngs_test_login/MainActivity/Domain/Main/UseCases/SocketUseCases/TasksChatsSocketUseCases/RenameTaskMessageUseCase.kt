package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksChatsSocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class RenameTaskMessageUseCase(private val mainRepository: MainRepository)
{
    fun execute(id: String?, taskId: String?, listId: String?, message: String?)
    {
        mainRepository.renameTaskMessage(id, taskId, listId, message)
    }
}