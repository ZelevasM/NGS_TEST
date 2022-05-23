package com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList

class ListSocketCallbackImpl(private var lists: ArrayList<DataList?>?,
                             private var listsData: MutableLiveData<ArrayList<DataList?>?>):
    ListSocketCallbackInterface
{
    override fun onChanged(list: DataList)
    {
        lists?.add(list)
        listsData.postValue(lists)
        Log.d("MyLog","List ADDDEEED")
    }
}