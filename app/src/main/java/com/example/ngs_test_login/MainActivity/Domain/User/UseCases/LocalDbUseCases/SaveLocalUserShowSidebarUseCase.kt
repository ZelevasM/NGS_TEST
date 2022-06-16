package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class SaveLocalUserShowSidebarUseCase(private val userRepository: UserRepository)
{
    fun execute(sidebar: String?)
    {
        userRepository.saveShowSidebar(null, db = null, sidebar = sidebar)
    }
}