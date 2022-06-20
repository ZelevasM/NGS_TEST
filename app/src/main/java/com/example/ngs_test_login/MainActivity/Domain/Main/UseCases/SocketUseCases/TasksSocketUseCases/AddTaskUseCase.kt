package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksSocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class AddTaskUseCase(private val mainRepository: MainRepository)
{
    fun execute(name: String, projectId: String, parentTaskId: String?)
    {
        mainRepository.addTask(name, projectId, parentTaskId)
    }
}