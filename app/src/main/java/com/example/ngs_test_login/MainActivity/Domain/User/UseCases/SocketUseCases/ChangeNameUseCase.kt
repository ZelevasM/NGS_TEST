package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class ChangeNameUseCase(private val userInterface: UserInterface)
{
    fun execute(name: String?)
    {
        userInterface.changeName(name)
    }
}