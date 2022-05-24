package com.example.ngs_test_login.MainActivity.Presentation.Base.SocketCallbacksImpl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.Base.SocketCallbacks.BaseSocketCallback

class BaseSocketCallbackImpl(private val responseVM: MutableLiveData<Boolean>): BaseSocketCallback
{
    override fun checkSocketResponse(response: Boolean)
    {
        if(response == true)
        {
            responseVM.postValue(response)
            Log.d("MyLog","Socket State: $response")
        }
        else
        {
            responseVM.postValue(response)
            Log.d("MyLog","Socket State: $response")
        }
    }
}