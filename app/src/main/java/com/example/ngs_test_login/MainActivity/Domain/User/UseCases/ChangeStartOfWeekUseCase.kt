package com.example.ngs_test_login.MainActivity.Domain.User.UseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class ChangeStartOfWeekUseCase(private val userInterface: UserInterface)
{
    fun execute()
    {
        userInterface.changeStartOfWeek()
    }
}