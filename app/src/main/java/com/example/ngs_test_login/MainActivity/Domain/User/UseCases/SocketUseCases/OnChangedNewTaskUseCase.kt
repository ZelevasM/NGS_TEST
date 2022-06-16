package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserNewTaskSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class OnChangedNewTaskUseCase(private val userRepository: UserRepository)
{
    fun execute(userNewTaskSocketCallbackInterface: UserNewTaskSocketCallbackInterface)
    {
        userRepository.onChangedNewTask(userNewTaskSocketCallbackInterface)
    }
}