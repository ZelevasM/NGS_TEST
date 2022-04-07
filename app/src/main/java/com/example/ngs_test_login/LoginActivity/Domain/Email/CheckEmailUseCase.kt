package com.example.ngs_test_login.LoginActivity.Domain.Email

import com.example.ngs_test_login.LoginActivity.Domain.LoginInterface
import com.example.ngs_test_login.LoginActivity.Domain.Models.User

class CheckEmailUseCase(private var loginInterface: LoginInterface)
{
    fun execute(email: User): Boolean
    {
        //boolean
        return loginInterface.emailCheck(email)
    }
}