package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksSocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class GetTaskUseCase(private val mainRepository: MainRepository)
{
    fun execute()
    {
        mainRepository.getTask()
    }
}