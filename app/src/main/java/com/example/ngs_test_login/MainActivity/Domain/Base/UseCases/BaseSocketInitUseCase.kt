package com.example.ngs_test_login.MainActivity.Domain.Base.UseCases

import com.example.ngs_test_login.MainActivity.Domain.Base.BaseInterface
import com.example.ngs_test_login.MainActivity.Domain.Base.SocketCallbacks.BaseSocketCallback
import io.socket.client.Socket

class BaseSocketInitUseCase(private val baseInterface: BaseInterface)
{
    fun execute(baseSocketCallback: BaseSocketCallback): Socket
    {
        val bSocket: Socket = baseInterface.socketInit(baseSocketCallback)
        return bSocket
    }
}