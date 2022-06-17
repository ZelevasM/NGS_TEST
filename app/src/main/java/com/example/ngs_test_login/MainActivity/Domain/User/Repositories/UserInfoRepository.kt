package com.example.ngs_test_login.MainActivity.Domain.User.Repositories

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserEmailSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserNameSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserPasswordSocketCallbackInterface

interface UserInfoRepository
{
    fun saveLocalName(name: String?)

    fun getLocalName(): String?

    fun saveLocalEmail(email: String?)

    fun getLocalEmail(): String?

    //Socket's Methods

    fun changeName(name: String?)

    fun onChangedName(userNameSocketCallbackInterface: UserNameSocketCallbackInterface)


    fun changeEmail(email: String?)

    fun onChangedEmail(userEmailSocketCallbackInterface: UserEmailSocketCallbackInterface)


    fun changePassword()

    fun onChangedPassword(userPassSocketCallbackInterface: UserPasswordSocketCallbackInterface)
}