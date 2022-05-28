package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserTimeFormatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Presentation.User.LocalDbProviders.UserLocalProvider

class UserTimeFormatSocketCallbackInterfaceImpl(private val userTimeFormatData: MutableLiveData<String?>,
                                                private val userLocalDbProvider: UserLocalProvider):
    UserTimeFormatSocketCallbackInterface
{
    override fun onChanged(timeFormat: String?)
    {
       userLocalDbProvider.saveTimeFormat(db=null, timeFormat = timeFormat)
        userTimeFormatData.postValue(userLocalDbProvider.getTimeFormat(db=null))
    }
}