package com.example.ngs_test_login.MainActivity.Presentation.Validators

import android.util.Log
import com.example.ngs_test_login.MainActivity.Domain.Models.Chat

class ChatValidator
{
    //TODO Change Validators to get exact results
    fun validateIncomingChat(chats: ArrayList<Chat?>?): Boolean
    {
        var checker: Boolean = false
        if (chats != null)
        {
            if (chats.size == 0)
            {
                Log.d("MyLog","Chats are empty: $chats")
            }
            else
            {
                checker = true
                Log.d("MyLog","Chats contain $chats")
            }
        }
        else
        {
            Log.d("MyLog","Chats are not downloaded!")
        }
        return checker
    }
}