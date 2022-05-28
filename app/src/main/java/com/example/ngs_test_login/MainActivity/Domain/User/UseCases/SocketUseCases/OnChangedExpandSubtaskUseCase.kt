package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserSubtaskSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class OnChangedExpandSubtaskUseCase(private val userInterface: UserInterface)
{
    fun execute(userSubtaskSocketCallbackInterface: UserSubtaskSocketCallbackInterface)
    {
        userInterface.onChangedExpandSubtask(userSubtaskSocketCallbackInterface)
    }
}