package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserDateFormatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Presentation.User.LocalDbProviders.UserLocalProvider

class UserDateFormatSocketCallbackInterfaceImpl(private val dateFormatData: MutableLiveData<String?>,
                                                private val userLocalDbProvider: UserLocalProvider):
    UserDateFormatSocketCallbackInterface
{
    override fun onChanged(date: String?)
    {
        userLocalDbProvider.saveDateFormat(db=null, dateFormat = date)
        dateFormatData.postValue(userLocalDbProvider.getDateFormat(db=null))
    }
}