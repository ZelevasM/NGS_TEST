package com.example.ngs_test_login.MainActivity.Presentation.User.Validators

import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.User.Models.ShortcutWeb

class ShortcutValidator
{
    fun validateIncomingShortcut(shortcutWebs: ArrayList<ShortcutWeb?>?): Boolean
    {
        var checker: Boolean = false
        if (shortcutWebs != null)
        {
            if (shortcutWebs.size == 0)
            {
                Log.d("MyLog","Shorts are empty: $shortcutWebs")
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