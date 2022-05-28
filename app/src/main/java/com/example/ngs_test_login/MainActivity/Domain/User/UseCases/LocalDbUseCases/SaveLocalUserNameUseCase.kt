package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class SaveLocalUserNameUseCase(private val userInterface: UserInterface)
{
    fun execute(name: String?)
    {
        userInterface.saveName(null, db = null, name = name)
    }
}