package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class ChangeDateFormatUseCase(private val userRepository: UserRepository)
{
    fun execute(dateFormat: String?)
    {
        userRepository.changeDateFormat(dateFormat)
    }
}