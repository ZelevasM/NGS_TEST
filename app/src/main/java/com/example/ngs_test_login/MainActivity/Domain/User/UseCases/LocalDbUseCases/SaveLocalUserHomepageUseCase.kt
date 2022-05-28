package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class SaveLocalUserHomepageUseCase(private val userInterface: UserInterface)
{
    fun execute(homepage: String?)
    {
        userInterface.saveHomepage(db=null, homepage = homepage)
    }
}