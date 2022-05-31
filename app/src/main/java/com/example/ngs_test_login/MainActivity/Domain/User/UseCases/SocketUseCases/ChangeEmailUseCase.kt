package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class ChangeEmailUseCase(private val userInterface: UserInterface)
{
    fun execute(email: String?)
    {
        userInterface.changeEmail(email)
    }
}