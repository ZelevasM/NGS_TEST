package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksSocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class RemindTaskUseCase(private val mainRepository: MainRepository)
{
    fun execute(id: String, projectId: String, remind: String?)
    {
        mainRepository.remindTask(id, projectId, remind)
    }
}