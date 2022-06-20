package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksSocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class DeleteTaskUseCase(private val mainRepository: MainRepository)
{
    fun execute(id: String, projectId: String)
    {
        mainRepository.deleteTask(id, projectId)
    }
}