package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class SaveLocalUserNewTaskUseCase(private val userRepository: UserRepository)
{
    fun execute(newTask: String?)
    {
        userRepository.saveNewTask(null, db = null, newTask = newTask)
    }
}