package com.example.ngs_test_login.MainActivity.Presentation.Main.Validators

import android.util.Log
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList

class ListValidator
{
    //TODO Change Validators to get exact results
    fun validateIncomingList(lists: ArrayList<DataList?>?): Boolean
    {
        var checker: Boolean = false
        if (lists != null)
        {
            if (lists.size == 0)
            {
                Log.d("MyLog","Lists are empty: $lists")
            }
            else
            {
                checker = true
                //Log.d("MyLog","Lists contain $lists")
            }
        }
        else
        {
            Log.d("MyLog","Lists are not downloaded!")
        }
        return checker
    }
}