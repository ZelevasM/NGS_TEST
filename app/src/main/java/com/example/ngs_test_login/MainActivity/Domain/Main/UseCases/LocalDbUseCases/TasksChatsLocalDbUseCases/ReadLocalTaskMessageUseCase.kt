package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.TasksChatsLocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class ReadLocalTaskMessageUseCase(private val mainRepository: MainRepository)
{
    fun execute(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {
        mainRepository.readLocalTaskMessage(taskMessage, taskId, listId)
    }
}