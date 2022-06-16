package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class GetLocalUserNewTaskUseCase(private val userRepository: UserRepository)
{
    fun execute(): String?
    {
        return userRepository.getNewTask(db=null)
    }
}