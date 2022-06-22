package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.TasksChatsLocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class AddLocalTaskMessageUseCase(private val mainRepository: MainRepository)
{
    fun execute(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {
        mainRepository.addLocalTaskMessage(taskMessage, taskId, listId)
    }
}