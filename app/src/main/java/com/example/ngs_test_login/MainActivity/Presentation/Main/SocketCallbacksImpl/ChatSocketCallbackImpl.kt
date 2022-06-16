package com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.Chat
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ChatSocketCallbackInterface

class ChatSocketCallbackImpl(private var chats: ArrayList<Chat?>?,
                             private var chatsData: MutableLiveData<ArrayList<Chat?>?>): ChatSocketCallbackInterface
{
    override fun onChanged(chat: Chat?)
    {
        chats?.add(chat)
        chatsData.postValue(chats)
        Log.d("MyLog","CHAT ADDEEEED")
    }
}