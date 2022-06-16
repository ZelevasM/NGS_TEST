package com.example.ngs_test_login.MainActivity.Domain.Base.Repositories

import com.example.ngs_test_login.MainActivity.Domain.Base.SocketCallbacks.BaseSocketCallback
import com.example.ngs_test_login.MainActivity.Domain.Base.Models.MainData
import io.socket.client.Socket


interface BaseRepository
{
    fun socketInit(baseSocketCallback: BaseSocketCallback): Socket

    fun getData(): MainData?
}