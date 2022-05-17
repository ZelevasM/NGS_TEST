package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases

import android.content.Context
import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.User

class AddLocalUserUseCase(private val mainInterface: MainInterface)
{
    fun execute(context: Context, user: User?)
    {
        mainInterface.addLocalUser(context, user)
    }
}