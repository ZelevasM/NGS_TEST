package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface
import io.socket.client.Socket

class UserSocketInitUseCase(private val userInterface: UserInterface)
{
    fun execute(bSocket: Socket)
    {
        userInterface.socketInit(bSocket)
    }
}