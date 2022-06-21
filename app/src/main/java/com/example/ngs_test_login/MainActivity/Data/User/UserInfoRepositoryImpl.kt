package com.example.ngs_test_login.MainActivity.Data.User

import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.User.Local.Mappers.UserEntityMapper
import com.example.ngs_test_login.MainActivity.Data.User.Local.UserDao
import com.example.ngs_test_login.MainActivity.Data.User.Web.UserSocket
import com.example.ngs_test_login.MainActivity.Domain.User.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserInfoRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserEmailSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserNameSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserPasswordSocketCallbackInterface
import io.socket.client.Socket

class UserInfoRepositoryImpl(private val userDao: UserDao): UserInfoRepository
{
    private lateinit var userSocket: UserSocket

    fun addUser(user: User?)
    {
        userDao.insertUser(UserEntityMapper().mapFromTToK(user))
    }

    fun getUser(): User?
    {
        if(userDao.getUser()?.size != 0)
        {
            return UserEntityMapper().mapFromKTOT(userDao.getUser()?.get(0))
        }
        return null
    }

    override fun saveLocalName(name: String?)
    {
        userDao.updateName(name)
    }

    override fun getLocalName(): String?
    {
        return userDao.getName()
    }

    override fun saveLocalEmail(email: String?)
    {
        userDao.updateEmail(email)
    }

    override fun getLocalEmail(): String?
    {
        return userDao.getEmail()
    }

    //Socket's Methods

    override fun socketInit(bSocket: Socket)
    {
        userSocket = UserSocket(bSocket)
    }

    override fun changeName(name: String?)
    {
        userSocket.changeName(name)
    }

    override fun onChangedName(userNameSocketCallbackInterface: UserNameSocketCallbackInterface)
    {
        userSocket.onChangedName(userNameSocketCallbackInterface)
    }

    override fun changeEmail(email: String?)
    {
        userSocket.changeEmail(email)
    }

    override fun onChangedEmail(userEmailSocketCallbackInterface: UserEmailSocketCallbackInterface)
    {
        userSocket.onChangedEmail(userEmailSocketCallbackInterface)
    }

    override fun changePassword()
    {
        userSocket.changePassword()
    }

    override fun onChangedPassword(userPassSocketCallbackInterface: UserPasswordSocketCallbackInterface)
    {
        userSocket.onChangedPassword(userPassSocketCallbackInterface)
    }
}