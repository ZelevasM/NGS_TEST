package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserNewTaskSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class OnChangedNewTaskUseCase(private val userInterface: UserInterface)
{
    fun execute(userNewTaskSocketCallbackInterface: UserNewTaskSocketCallbackInterface)
    {
        userInterface.onChangedNewTask(userNewTaskSocketCallbackInterface)
    }
}