package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository
import io.socket.client.Socket

class MainSocketInitUseCase(private val mainRepository: MainRepository)
{
    fun execute(bSocket: Socket)
    {
        mainRepository.socketInit(bSocket)
    }
}