package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class ChangeExpandSubtaskUseCase(private val userInterface: UserInterface)
{
    fun execute(expandSubtask: String?)
    {
        userInterface.changeExpandSubtask(expandSubtask)
    }
}