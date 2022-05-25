package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class GetLocalUserUseCase(private val userInterface: UserInterface)
{
    fun execute(): User?
    {
        val user: User? = userInterface.getLocalUser()
        return user
    }
}