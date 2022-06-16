package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class SaveLocalUserStartOfWeekUseCase(private val userRepository: UserRepository)
{
    fun execute(startOfWeek: String?)
    {
        userRepository.saveStartOfWeek(db = null, startOfWeek = startOfWeek)
    }
}