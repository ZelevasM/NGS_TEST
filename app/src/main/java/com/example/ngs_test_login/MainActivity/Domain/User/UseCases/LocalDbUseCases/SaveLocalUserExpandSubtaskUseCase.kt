package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class SaveLocalUserExpandSubtaskUseCase(private val userInterface: UserInterface)
{
    fun execute(expandSubtask: String?)
    {
        userInterface.saveExpandSubtask(null, db = null, expandSubtask = expandSubtask)
    }
}