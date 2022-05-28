package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class ChangeHomepageUseCase(private val userInterface: UserInterface)
{
    fun execute(homepage: String?)
    {
        userInterface.changeHomepage(homepage)
    }
}