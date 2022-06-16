package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class SaveLocalUserDiskSpaceUseCase(private val userRepository: UserRepository)
{
    fun execute(diskSpace: String?)
    {
        userRepository.saveDiskSpace(null, db = null, diskSpace = diskSpace)
    }
}