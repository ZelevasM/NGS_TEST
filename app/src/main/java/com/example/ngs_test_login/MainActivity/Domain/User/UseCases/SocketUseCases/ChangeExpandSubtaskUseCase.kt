package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class ChangeExpandSubtaskUseCase(private val userRepository: UserRepository)
{
    fun execute(expandSubtask: String?)
    {
        userRepository.changeExpandSubtask(expandSubtask)
    }
}