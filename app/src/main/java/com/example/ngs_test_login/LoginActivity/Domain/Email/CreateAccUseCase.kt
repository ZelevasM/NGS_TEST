package com.example.ngs_test_login.LoginActivity.Domain.Email

import com.example.ngs_test_login.LoginActivity.Domain.LoginInterface
import com.example.ngs_test_login.LoginActivity.Domain.Models.User

class CreateAccUseCase (private var loginInterface: LoginInterface)
{
    fun execute(name: User): Boolean
    {
        return loginInterface.emailSignUp(name)
    }
}