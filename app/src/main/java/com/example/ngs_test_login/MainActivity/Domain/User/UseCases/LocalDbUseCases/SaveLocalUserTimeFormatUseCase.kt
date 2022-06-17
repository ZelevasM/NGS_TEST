package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class SaveLocalUserTimeFormatUseCase(private val userRepository: UserRepository)
{
    fun execute(timeFormat: String?)
    {
        return userRepository.saveLocalTimeFormat(timeFormat = timeFormat)
    }
}