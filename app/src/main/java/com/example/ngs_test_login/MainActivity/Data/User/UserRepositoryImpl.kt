package com.example.ngs_test_login.MainActivity.Data.User

import com.example.ngs_test_login.MainActivity.Data.User.Web.UserSocket
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository
import io.socket.client.Socket

class UserRepositoryImpl: UserRepository
{
    private lateinit var mSocket: Socket
    private lateinit var userSocket: UserSocket
    //Local DB

    override fun socketInit(bSocket: Socket)
    {
        mSocket = bSocket
        userSocket = UserSocket(mSocket)
    }
}