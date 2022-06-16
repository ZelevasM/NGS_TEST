package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class ChangeNewTaskUseCase(private val userRepository: UserRepository)
{
    fun execute(newTask: String?)
    {
        userRepository.changeNewTask(newTask)
    }
}