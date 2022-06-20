package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksSocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.TaskSocketCallbackInterface

class GetTaskUseCase(private val mainRepository: MainRepository)
{
    fun execute(taskSocketCallbackInterface: TaskSocketCallbackInterface)
    {
        mainRepository.getTask(taskSocketCallbackInterface)
    }
}