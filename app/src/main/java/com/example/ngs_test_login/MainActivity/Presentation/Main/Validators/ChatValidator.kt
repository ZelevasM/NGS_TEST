package com.example.ngs_test_login.MainActivity.Presentation.Main.Validators

import android.util.Log
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.Chat

class ChatValidator
{
    //TODO Change Validators to get exact results
    fun validateIncomingChat(chatWebs: ArrayList<Chat?>?): Boolean
    {
        var checker: Boolean = false
        if (chatWebs != null)
        {
            if (chatWebs.size == 0)
            {
                Log.d("MyLog","Chats are empty: $chatWebs")
            }
            else
            {
                checker = true
                //Log.d("MyLog","Chats contain $chats")
            }
        }
        else
        {
            Log.d("MyLog","Chats are not downloaded!")
        }
        return checker
    }
}