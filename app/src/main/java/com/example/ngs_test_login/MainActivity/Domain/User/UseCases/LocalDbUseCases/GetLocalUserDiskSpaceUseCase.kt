package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class GetLocalUserDiskSpaceUseCase(private val userInterface: UserInterface)
{
    fun execute(): String?
    {
        return userInterface.getDiskSpace(db=null)
    }
}