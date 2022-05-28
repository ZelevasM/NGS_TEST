package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class GetLocalUserIdUseCase(private val userInterface: UserInterface)
{
    fun execute(): String?
    {
        return userInterface.getId(db = null)
    }
}