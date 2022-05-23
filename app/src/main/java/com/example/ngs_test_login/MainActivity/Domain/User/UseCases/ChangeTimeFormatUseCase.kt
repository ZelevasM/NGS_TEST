package com.example.ngs_test_login.MainActivity.Domain.User.UseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class ChangeTimeFormatUseCase(private val userInterface: UserInterface)
{
    fun execute()
    {
        userInterface.changeTimeFormat()
    }
}