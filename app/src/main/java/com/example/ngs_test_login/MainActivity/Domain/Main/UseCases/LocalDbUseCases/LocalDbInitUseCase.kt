package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases

import android.content.Context
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class LocalDbInitUseCase(private val mainRepository: MainRepository)
{
    fun execute(context: Context)
    {
        mainRepository.localDbInit(context)
    }
}