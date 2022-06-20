package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksSocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class DoneTaskUseCase(private val mainRepository: MainRepository)
{
    fun execute(id: String, projectId: String, done: Boolean)
    {
        mainRepository.doneTask(id, projectId, done)
    }
}