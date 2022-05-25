package com.example.ngs_test_login.MainActivity.Presentation

import android.content.Context
import io.socket.client.Socket

interface ViewModelInterface
{
    fun socketInit(vararg bSocket: Socket)

    fun localDbInit(context: Context)

    fun localDbClose()
}