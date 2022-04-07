package com.example.ngs_test_login.LoginActivity.Domain.Email

import com.example.ngs_test_login.LoginActivity.Domain.LoginInterface
import com.example.ngs_test_login.LoginActivity.Domain.Models.User

class CheckPassUseCase(private val loginInterface: LoginInterface)
{
    fun execute(password: User): Boolean
    {
        return loginInterface.emailPassCheck(password)
    }
}