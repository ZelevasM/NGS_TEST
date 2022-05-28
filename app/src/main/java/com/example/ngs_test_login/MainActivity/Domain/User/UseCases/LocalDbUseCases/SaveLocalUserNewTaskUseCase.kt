package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class SaveLocalUserNewTaskUseCase(private val userInterface: UserInterface)
{
    fun execute(newTask: String?)
    {
        userInterface.saveNewTask(null, db = null, newTask = newTask)
    }
}