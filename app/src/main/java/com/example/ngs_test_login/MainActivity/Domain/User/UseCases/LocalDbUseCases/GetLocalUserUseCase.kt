package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Data.User.Web.Models.UserWeb
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class GetLocalUserUseCase(private val userRepository: UserRepository)
{
    fun execute(): UserWeb?
    {
        val userWeb: UserWeb? = userRepository.getLocalUser()
        return userWeb
    }
}