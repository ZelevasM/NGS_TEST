package com.example.ngs_test_login.MainActivity.Domain.User.UseCases

import android.content.Context
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class LocalUserDbInitUseCase(private val userInterface: UserInterface)
{
    fun execute(context: Context)
    {
        userInterface.localDbInit(context)
    }
}