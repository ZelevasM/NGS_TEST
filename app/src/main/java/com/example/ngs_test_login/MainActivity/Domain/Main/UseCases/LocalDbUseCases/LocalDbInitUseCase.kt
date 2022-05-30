package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases

import android.content.Context
import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface

class LocalDbInitUseCase(private val mainInterface: MainInterface)
{
    fun execute(context: Context)
    {
        mainInterface.localDbInit(context)
    }
}