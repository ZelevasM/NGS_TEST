package com.example.ngs_test_login.MainActivity.Data.Base.Web

import android.util.Log
import com.example.ngs_test_login.BuildConfig
import com.example.ngs_test_login.MainActivity.Domain.Base.SocketCallbacks.BaseSocketCallback
import io.socket.client.IO
import io.socket.client.Socket

class BaseSocket()
{
    private val DOMAIN = BuildConfig.DOMAIN
    private val authString: String = "Authorization"
    private val options = IO.Options().apply {
        this.forceNew = true
        this.reconnection = true
        this.extraHeaders = mutableMapOf(authString to  listOf(BuildConfig.Token))
    }

    fun initialize(baseSocketCallback: BaseSocketCallback): Socket
    {
        val bSocket = IO.socket(DOMAIN, options)
        bSocket.connect()

        bSocket.on(Socket.EVENT_CONNECT)
        {
            Log.d("MyLog","ConnSs")
            Log.d("MyLog","Connexion: ${bSocket.connected()}")
            baseSocketCallback.checkSocketResponse(bSocket.connected())
        }

        bSocket.on(Socket.EVENT_CONNECT_ERROR)
        {
            Log.d("MyLog","ConnError")
            Log.d("MyLog","Connexion: ${bSocket.connected()}")
            baseSocketCallback.checkSocketResponse(bSocket.connected())
        }

        bSocket.on(Socket.EVENT_DISCONNECT)
        {
            Log.d("MyLog","DisConn")
            Log.d("MyLog","Connexion: ${bSocket.connected()}")
            baseSocketCallback.checkSocketResponse(bSocket.connected())
        }

        return bSocket
    }
}