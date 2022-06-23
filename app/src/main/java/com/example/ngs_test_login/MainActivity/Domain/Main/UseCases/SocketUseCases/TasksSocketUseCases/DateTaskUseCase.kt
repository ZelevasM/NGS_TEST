package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksSocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class DateTaskUseCase(private val mainRepository: MainRepository)
{
    fun execute(id: String, projectId: String, date: String?)
    {
        mainRepository.dateTask(id, projectId, date)
    }
}