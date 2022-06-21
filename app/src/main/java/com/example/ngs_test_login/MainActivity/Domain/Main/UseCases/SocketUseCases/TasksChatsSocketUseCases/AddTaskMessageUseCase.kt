package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksChatsSocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class AddTaskMessageUseCase(private val mainRepository: MainRepository)
{
    fun execute(userId: String?, taskId: String?, listId: String?, message: String?, replyChatId: String?, fileId: String?)
    {
        mainRepository.addTaskMessage(userId, taskId, listId, message, replyChatId, fileId)
    }
}