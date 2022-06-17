package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class SaveLocalUserExpandSubtaskUseCase(private val userRepository: UserRepository)
{
    fun execute(expandSubtask: String?)
    {
        userRepository.saveLocalExpandSubtask(expandSubtask = expandSubtask)
    }
}