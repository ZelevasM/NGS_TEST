package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Data.User.Models.UserWeb
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class AddLocalUserUseCase(private val userInterface: UserInterface)
{
    fun execute(userWeb: UserWeb?)
    {
        userInterface.addLocalUser(userWeb)
    }
}