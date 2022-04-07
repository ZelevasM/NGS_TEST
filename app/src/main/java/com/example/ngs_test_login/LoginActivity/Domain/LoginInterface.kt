package com.example.ngs_test_login.LoginActivity.Domain

import com.example.ngs_test_login.LoginActivity.Domain.Models.User

interface LoginInterface
{
    fun emailCheck(email: User): Boolean

    fun emailPassCheck(password: User): Boolean

    fun emailSignUp(user: User): Boolean

    fun privacy()

    fun terms()

    fun googleCont()

    fun appleCont()

    fun fbCont()
}