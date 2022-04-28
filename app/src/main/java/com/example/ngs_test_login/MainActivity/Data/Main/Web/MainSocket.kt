package com.example.ngs_test_login.MainActivity.Data.Main.Web

import android.util.Log
import com.example.ngs_test_login.BuildConfig
import io.socket.client.IO
import io.socket.client.Socket

class MainSocket()
{
    private val DOMAIN = BuildConfig.DOMAIN
    private val authString: String = "Authorization"
    private val options = IO.Options().apply {
        this.forceNew = true
        this.reconnection = true
        this.extraHeaders = mutableMapOf(authString to  listOf(BuildConfig.Token))
    }

    fun initialize(): Socket
    {
        val mSocket = IO.socket(DOMAIN, options)
        mSocket.connect()

        mSocket.on(Socket.EVENT_CONNECT)
        {
            Log.d("MyLog","ConnSs")
            Log.d("MyLog","Connexion: ${mSocket.connected()}")
        }

        mSocket.on(Socket.EVENT_CONNECT_ERROR)
        {
            Log.d("MyLog","ConnError")
            Log.d("MyLog","Connexion: ${mSocket.connected()}")
        }

        mSocket.on(Socket.EVENT_DISCONNECT)
        {
            Log.d("MyLog","DisConn")
            Log.d("MyLog","Connexion: ${mSocket.connected()}")
        }

        return mSocket
    }
}