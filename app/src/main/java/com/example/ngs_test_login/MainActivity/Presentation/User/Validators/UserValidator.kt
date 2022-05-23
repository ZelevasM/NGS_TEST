package com.example.ngs_test_login.MainActivity.Presentation.User.Validators

import android.util.Log
import com.example.ngs_test_login.MainActivity.Domain.Models.User

class UserValidator
{
    fun validateIncomingUser(user: User?): Boolean
    {
        var checker: Boolean = false
        if (user != null)
        {
            checker = true
            //Log.d("MyLog","User contain $user")
        }
        else
        {
            Log.d("MyLog","User is not downloaded!")
        }
        return checker
    }
}