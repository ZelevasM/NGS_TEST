package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class SaveLocalUserHomepageUseCase(private val userRepository: UserRepository)
{
    fun execute(homepage: String?)
    {
        userRepository.saveHomepage(db=null, homepage = homepage)
    }
}