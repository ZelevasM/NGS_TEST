package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class ChangeHomepageUseCase(private val userRepository: UserRepository)
{
    fun execute(homepage: String?)
    {
        userRepository.changeHomepage(homepage)
    }
}