package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class ChangeTimeFormatUseCase(private val userRepository: UserRepository)
{
    fun execute(timeFormat: String?)
    {
        userRepository.changeTimeFormat(timeFormat)
    }
}