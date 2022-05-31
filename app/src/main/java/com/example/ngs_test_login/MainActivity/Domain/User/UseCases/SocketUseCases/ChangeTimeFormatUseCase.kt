package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class ChangeTimeFormatUseCase(private val userInterface: UserInterface)
{
    fun execute(timeFormat: String?)
    {
        userInterface.changeTimeFormat(timeFormat)
    }
}