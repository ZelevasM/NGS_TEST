package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import io.socket.client.Socket

class MainSocketInitUseCase(private val mainInterface: MainInterface)
{
    fun execute(bSocket: Socket)
    {
        mainInterface.socketInit(bSocket)
    }
}