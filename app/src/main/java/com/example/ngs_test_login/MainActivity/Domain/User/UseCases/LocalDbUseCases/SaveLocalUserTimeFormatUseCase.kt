package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class SaveLocalUserTimeFormatUseCase(private val userInterface: UserInterface)
{
    fun execute(timeFormat: String?)
    {
        return userInterface.saveTimeFormat(db = null, timeFormat = timeFormat)
    }
}