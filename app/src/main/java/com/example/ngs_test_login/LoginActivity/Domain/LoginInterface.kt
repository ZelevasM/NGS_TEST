package com.example.ngs_test_login.LoginActivity.Domain

import com.example.ngs_test_login.LoginActivity.Domain.Models.User

/**
 * interface LoginInterface provides an abstract layer in the Domain,
 * providing the access to all its' functions in the classes that utilize it
 * @sample FBUseCase can accept interface LoginInterface as an argument,
 * and then call its fbCont() function (fbcont means Continue with Facebook)
 */
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