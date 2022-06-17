package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class SaveLocalUserDateFormatUseCase(private val userRepository: UserRepository)
{
    fun execute(dateFormat: String?)
    {
        userRepository.saveLocalDateFormat(dateFormat = dateFormat)
    }
}