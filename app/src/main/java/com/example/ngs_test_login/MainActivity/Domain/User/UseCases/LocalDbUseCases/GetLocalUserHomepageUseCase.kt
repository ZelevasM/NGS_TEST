package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class GetLocalUserHomepageUseCase(private val userRepository: UserRepository)
{
    fun execute(): String?
    {
        return userRepository.getHomepage(db=null)
    }
}