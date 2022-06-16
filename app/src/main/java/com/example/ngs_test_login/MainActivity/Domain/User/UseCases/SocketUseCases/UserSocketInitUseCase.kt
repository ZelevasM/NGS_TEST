package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository
import io.socket.client.Socket

class UserSocketInitUseCase(private val userRepository: UserRepository)
{
    fun execute(bSocket: Socket)
    {
        userRepository.socketInit(bSocket)
    }
}