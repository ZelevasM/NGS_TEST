package com.example.ngs_test_login.MainActivity.Data.User

import com.example.ngs_test_login.MainActivity.Data.User.Local.UserDao
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserInfoRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserEmailSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserNameSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserPasswordSocketCallbackInterface

class UserInfoRepositoryImpl(private val userDao: UserDao): UserInfoRepository
{
    override fun saveLocalName(name: String?)
    {

    }

    override fun getLocalName(): String?
    {
        TODO("Not yet implemented")
    }

    override fun saveLocalEmail(email: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalEmail(): String?
    {
        TODO("Not yet implemented")
    }

    //Socket's Methods

    override fun changeName(name: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedName(userNameSocketCallbackInterface: UserNameSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }

    override fun changeEmail(email: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedEmail(userEmailSocketCallbackInterface: UserEmailSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }

    override fun changePassword()
    {
        TODO("Not yet implemented")
    }

    override fun onChangedPassword(userPassSocketCallbackInterface: UserPasswordSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }
}