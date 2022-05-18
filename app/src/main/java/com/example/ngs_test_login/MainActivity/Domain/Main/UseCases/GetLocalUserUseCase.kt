package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.User

class GetLocalUserUseCase(private val mainInterface: MainInterface)
{
    fun execute(): User?
    {
        val user: User? = mainInterface.getLocalUser()
        return user
    }
}