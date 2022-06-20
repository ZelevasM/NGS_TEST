package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksSocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class OrderTaskUseCase(private val mainRepository: MainRepository)
{
    fun execute()
    {
        mainRepository.orderTask()
    }
}