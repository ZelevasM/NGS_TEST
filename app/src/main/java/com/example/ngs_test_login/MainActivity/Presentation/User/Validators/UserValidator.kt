package com.example.ngs_test_login.MainActivity.Presentation.User.Validators

import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.User.Models.UserWeb

class UserValidator
{
    fun validateIncomingUser(userWeb: UserWeb?): Boolean
    {
        var checker: Boolean = false
        if (userWeb != null)
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