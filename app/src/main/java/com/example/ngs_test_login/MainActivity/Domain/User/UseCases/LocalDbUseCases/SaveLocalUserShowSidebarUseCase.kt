package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class SaveLocalUserShowSidebarUseCase(private val userInterface: UserInterface)
{
    fun execute(sidebar: String?)
    {
        userInterface.saveShowSidebar(null, db = null, sidebar = sidebar)
    }
}