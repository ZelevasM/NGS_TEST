package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.TasksLocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class GetLocalTaskUseCase(private val mainRepository: MainRepository)
{
    fun execute(taskId: String?, listId: String)
    {
        mainRepository.getLocalTask(taskId, listId)
    }
}