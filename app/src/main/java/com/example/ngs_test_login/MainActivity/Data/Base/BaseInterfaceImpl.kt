package com.example.ngs_test_login.MainActivity.Data.Base

import com.example.ngs_test_login.MainActivity.Data.Base.Web.BaseSocket
import com.example.ngs_test_login.MainActivity.Domain.Base.BaseInterface
import com.example.ngs_test_login.MainActivity.Domain.Base.SocketCallbacks.BaseSocketCallback
import io.socket.client.Socket

class BaseInterfaceImpl: BaseInterface
{
    private lateinit var bSocket: Socket

    override fun socketInit(baseSocketCallback: BaseSocketCallback): Socket?
    {
        bSocket = BaseSocket().initialize(baseSocketCallback)
        return bSocket
    }
}