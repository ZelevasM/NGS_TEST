package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class ChangeNameUseCase(private val userRepository: UserRepository)
{
    fun execute(name: String?)
    {
        userRepository.changeName(name)
    }
}