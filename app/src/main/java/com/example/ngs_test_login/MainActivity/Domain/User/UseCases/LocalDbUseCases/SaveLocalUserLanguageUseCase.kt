package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class SaveLocalUserLanguageUseCase(private val userRepository: UserRepository)
{
    fun execute(language: String?)
    {
        userRepository.saveLanguage(null, db = null, language = language)
    }
}