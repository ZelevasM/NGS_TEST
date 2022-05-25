package com.example.ngs_test_login.MainActivity.Domain.Base

import com.example.ngs_test_login.MainActivity.Domain.Base.SocketCallbacks.BaseSocketCallback
import com.example.ngs_test_login.MainActivity.Domain.Models.MainData
import io.socket.client.Socket


interface BaseInterface
{
    fun socketInit(baseSocketCallback: BaseSocketCallback): Socket

    fun getData(): MainData?
}