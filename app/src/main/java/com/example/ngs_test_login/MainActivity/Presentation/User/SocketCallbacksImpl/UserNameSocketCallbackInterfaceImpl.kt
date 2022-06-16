package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserNameSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Presentation.User.LocalDbProviders.User

class UserNameSocketCallbackInterfaceImpl(private val userName: MutableLiveData<String?>,
                                          private val userLocalDbProvider: User):
    UserNameSocketCallbackInterface
{
    override fun onChanged(name: String?)
    {
        userLocalDbProvider.saveName(db = null, name = name)
        userName.postValue(userLocalDbProvider.getName(db=null))
    }
}