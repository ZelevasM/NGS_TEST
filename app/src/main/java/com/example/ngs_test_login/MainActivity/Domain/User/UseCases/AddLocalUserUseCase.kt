package com.example.ngs_test_login.MainActivity.Domain.User.UseCases

import android.content.Context
import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class AddLocalUserUseCase(private val userInterface: UserInterface)
{
    fun execute(context: Context, user: User?)
    {
        userInterface.addLocalUser(context, user)
    }
}