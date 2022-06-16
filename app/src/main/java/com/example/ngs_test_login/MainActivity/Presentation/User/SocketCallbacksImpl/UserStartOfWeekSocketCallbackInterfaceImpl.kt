package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserStartOfWeekSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Presentation.User.LocalDbProviders.User

class UserStartOfWeekSocketCallbackInterfaceImpl(private val startOfWeekData: MutableLiveData<String?>,
                                            private val userLocalDbProvider: User):
    UserStartOfWeekSocketCallbackInterface
{
    override fun onChanged(startOfWeek: String?)
    {
        userLocalDbProvider.saveStartOfWeek(db=null, startOfWeek = startOfWeek)
        startOfWeekData.postValue(userLocalDbProvider.getStartOfWeek(db=null))
    }
}