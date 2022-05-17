package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases

import android.content.Context
import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface

class LocalDbInitUseCase(private val mainInterface: MainInterface)
{
    fun execute(context: Context): Boolean?
    {
        val newlyCreated: Boolean? = mainInterface.localDbInit(context)
        return newlyCreated
    }
}