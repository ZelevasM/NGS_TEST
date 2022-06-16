package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class LocalUserDbCloseUseCase(private val userRepository: UserRepository)
{
    fun execute()
    {
        userRepository.localDbClose()
    }
}