package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class GetLocalUserExpandSubtaskUseCase(private val userInterface: UserInterface)
{
    fun execute(): String?
    {
        return userInterface.getExpandSubtask(db=null)
    }
}