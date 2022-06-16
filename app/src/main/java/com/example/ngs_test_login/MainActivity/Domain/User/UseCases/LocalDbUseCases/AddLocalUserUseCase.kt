package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class AddLocalUserUseCase(private val userRepository: UserRepository)
{
    fun execute(user: User?)
    {
        userRepository.addLocalUser(user)
    }
}