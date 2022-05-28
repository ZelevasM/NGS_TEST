package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class SaveLocalUserDateFormatUseCase(private val userInterface: UserInterface)
{
    fun execute(dateFormat: String?)
    {
        userInterface.saveDateFormat(db = null, dateFormat = dateFormat)
    }
}