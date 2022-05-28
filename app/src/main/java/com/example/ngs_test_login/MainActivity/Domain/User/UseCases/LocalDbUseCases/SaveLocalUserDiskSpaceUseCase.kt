package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class SaveLocalUserDiskSpaceUseCase(private val userInterface: UserInterface)
{
    fun execute(diskSpace: String?)
    {
        userInterface.saveDiskSpace(null, db = null, diskSpace = diskSpace)
    }
}