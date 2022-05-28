package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class SaveLocalUserStartOfWeekUseCase(private val userInterface: UserInterface)
{
    fun execute(startOfWeek: String?)
    {
        userInterface.saveStartOfWeek(db = null, startOfWeek = startOfWeek)
    }
}