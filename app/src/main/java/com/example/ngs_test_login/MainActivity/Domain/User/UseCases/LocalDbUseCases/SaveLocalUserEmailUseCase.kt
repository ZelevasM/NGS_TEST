package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class SaveLocalUserEmailUseCase(private val userInterface: UserInterface)
{
    fun execute(email: String?)
    {
        userInterface.saveEmail(null,db = null,email = email)
    }
}