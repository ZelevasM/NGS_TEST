package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class SaveLocalUserNameUseCase(private val userRepository: UserRepository)
{
    fun execute(name: String?)
    {
        userRepository.saveLocalName(name = name)
    }
}