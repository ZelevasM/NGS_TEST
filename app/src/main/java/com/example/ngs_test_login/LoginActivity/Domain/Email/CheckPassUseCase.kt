package com.example.ngs_test_login.LoginActivity.Domain.Email

import com.example.ngs_test_login.LoginActivity.Domain.LoginInterface
import com.example.ngs_test_login.LoginActivity.Domain.Models.User

/**
 * CheckPassUseCase is used to provide an abstract layer in the Domain,
 * for operations related to the checking of the user's password
 * @param loginInterface
 */
class CheckPassUseCase(private val loginInterface: LoginInterface)
{
    /**
     * fun execute performs the checking of the input password:User,
     * and returns the boolean value, obtained by the emailPassCheck method of loginInterface
     * @param password: User
     * @return boolean
     * !NOTE: that @param password is an instance of a class User, and it contains all of its fields
     */
    fun execute(password: User): Boolean
    {
        return loginInterface.emailPassCheck(password)
    }
}