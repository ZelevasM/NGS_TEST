package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import android.content.Context
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class LocalUserDbInitUseCase(private val userRepository: UserRepository)
{
    fun execute(context: Context)
    {
        userRepository.localDbInit(context)
    }
}