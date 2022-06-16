package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class ChangeEmailUseCase(private val userRepository: UserRepository)
{
    fun execute(email: String?)
    {
        userRepository.changeEmail(email)
    }
}