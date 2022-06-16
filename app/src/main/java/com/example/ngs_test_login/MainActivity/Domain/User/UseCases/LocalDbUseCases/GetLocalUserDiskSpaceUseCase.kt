package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class GetLocalUserDiskSpaceUseCase(private val userRepository: UserRepository)
{
    fun execute(): String?
    {
        return userRepository.getDiskSpace(db=null)
    }
}