package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class SaveLocalUserLanguageUseCase(private val userInterface: UserInterface)
{
    fun execute(language: String?)
    {
        userInterface.saveLanguage(null, db = null, language = language)
    }
}