package com.example.ngs_test_login.LoginActivity.Domain.Email

import com.example.ngs_test_login.LoginActivity.Domain.LoginInterface
import com.example.ngs_test_login.LoginActivity.Domain.Models.UserFromLogin

/**
* CheckEmailUseCase is used to provide an abstract layer in the Domain,
* for operations related to the checking of the user's email address
 * @param loginInterface
*/
class CheckEmailUseCase(private var loginInterface: LoginInterface)
{
    /**
     * fun execute performs the checking of the input email:User,
     * and returns the boolean value, obtained by the emailCheck method of loginInterface
     * @param email: User
     * @return boolean
     * !NOTE: that @param email is an instance of a class User, and it contains all of its fields
     */
    fun execute(email: UserFromLogin): Boolean
    {
        return loginInterface.emailCheck(email)
    }
}