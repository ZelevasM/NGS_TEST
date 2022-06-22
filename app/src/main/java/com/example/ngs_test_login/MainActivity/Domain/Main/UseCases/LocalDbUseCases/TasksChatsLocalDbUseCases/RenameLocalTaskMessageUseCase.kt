package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.TasksChatsLocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class RenameLocalTaskMessageUseCase(private val mainRepository: MainRepository)
{
    fun execute(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {
        mainRepository.renameLocalTaskMessage(taskMessage, taskId, listId)
    }
}