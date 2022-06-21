package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksChatsSocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.TaskChatCallbackInterface

class GetTaskMessageUseCase(private val mainRepository: MainRepository)
{
    fun execute(taskChatCallbackInterface: TaskChatCallbackInterface)
    {
        mainRepository.getTaskMessage(taskChatCallbackInterface)
    }
}