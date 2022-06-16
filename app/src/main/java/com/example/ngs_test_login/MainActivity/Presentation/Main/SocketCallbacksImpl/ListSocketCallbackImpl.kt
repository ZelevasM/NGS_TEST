package com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface

class ListSocketCallbackImpl(private var lists: ArrayList<DataList?>?,
                             private var listsData: MutableLiveData<ArrayList<DataList?>?>):
    ListSocketCallbackInterface
{
    override fun onAdded(list: DataList?)
    {
        lists?.add(list)
        listsData.postValue(lists)
        Log.d("MyLog","List ADDDEEED")
    }

    override fun onUpdated(list: DataList?)
    {
        for(i in lists?.indices!!)
        {
            if(list?.id == lists!![i]?.id)
            {
                lists!![i]?.name = list?.name
                break
            }
        }
        listsData.postValue(lists)
        Log.d("MyLog","List UPDATEEED")
    }

    override fun onDeleted(list: DataList?)
    {
        for(i in lists?.indices!!)
        {
            if(list?.id == lists!![i]?.id)
            {
                lists?.removeAt(i)
                break
            }
        }
        listsData.postValue(lists)
        Log.d("MyLog","List DELETEEED")
    }
}