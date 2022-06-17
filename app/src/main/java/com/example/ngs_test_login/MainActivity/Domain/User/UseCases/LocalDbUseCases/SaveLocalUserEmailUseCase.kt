package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class SaveLocalUserEmailUseCase(private val userRepository: UserRepository)
{
    fun execute(email: String?)
    {
        userRepository.saveLocalEmail(email = email)
    }
}