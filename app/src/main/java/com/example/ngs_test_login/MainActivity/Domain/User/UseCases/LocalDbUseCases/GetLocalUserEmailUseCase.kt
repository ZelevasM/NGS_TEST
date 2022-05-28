package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class GetLocalUserEmailUseCase(private val userInterface: UserInterface)
{
    fun execute(): String?
    {
        return userInterface.getEmail(db = null)
    }
}