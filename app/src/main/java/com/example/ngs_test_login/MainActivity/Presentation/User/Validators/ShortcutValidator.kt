package com.example.ngs_test_login.MainActivity.Presentation.User.Validators

import android.util.Log
import com.example.ngs_test_login.MainActivity.Domain.Models.Shortcut

class ShortcutValidator
{
    fun validateIncomingShortcut(shortcuts: ArrayList<Shortcut?>?): Boolean
    {
        var checker: Boolean = false
        if (shortcuts != null)
        {
            if (shortcuts.size == 0)
            {
                Log.d("MyLog","Shorts are empty: $shortcuts")
            }
            else
            {
                checker = true
                //Log.d("MyLog","Shorts contain $shortcuts")
            }
        }
        else
        {
            Log.d("MyLog","Shorts are not downloaded!")
        }
        return checker
    }
}