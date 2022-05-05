package com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks

import com.example.ngs_test_login.MainActivity.Domain.Models.Chat

interface ChatSocketCallbackInterface
{
    fun onChanged(chat: Chat)
}