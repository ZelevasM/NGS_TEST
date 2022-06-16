package com.example.ngs_test_login.MainActivity.Domain.Base.UseCases

import com.example.ngs_test_login.MainActivity.Domain.Base.Repositories.BaseRepository
import com.example.ngs_test_login.MainActivity.Domain.Base.SocketCallbacks.BaseSocketCallback
import io.socket.client.Socket

class BaseSocketInitUseCase(private val baseRepository: BaseRepository)
{
    fun execute(baseSocketCallback: BaseSocketCallback): Socket
    {
        val bSocket: Socket = baseRepository.socketInit(baseSocketCallback)
        return bSocket
    }
}