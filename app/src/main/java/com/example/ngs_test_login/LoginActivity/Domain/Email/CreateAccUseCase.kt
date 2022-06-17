package com.example.ngs_test_login.LoginActivity.Domain.Email

import com.example.ngs_test_login.LoginActivity.Domain.LoginInterface
import com.example.ngs_test_login.LoginActivity.Domain.Models.UserFromLogin

/**
 * CreateAccUseCase is used to provide an abstract layer in the Domain,
 * for operations related to the registration of a new user
 * @param loginInterface
 */
class CreateAccUseCase (private var loginInterface: LoginInterface)
{
    /**
     * fun execute performs the checking of the input name:User,
     * and returns the boolean value, obtained by the emailSignUp method of loginInterface
     * @param name: User
     * @return boolean
     * !NOTE: that @param name is an instance of a class User, and it contains all of its fields
     */
    fun execute(name: UserFromLogin): Boolean
    {
        return loginInterface.emailSignUp(name)
    }
}