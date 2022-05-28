package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class GetLocalUserStartOfWeekUseCase(private val userInterface: UserInterface)
{
    fun execute(): String?
    {
        return userInterface.getStartOfWeek(db = null)
    }
}