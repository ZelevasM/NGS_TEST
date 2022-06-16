package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserEmailSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Presentation.User.LocalDbProviders.User

class UserEmailSocketCallbackInterfaceImpl(private val userMail: MutableLiveData<String?>,
                                            private val userLocalDbProvider: User):
    UserEmailSocketCallbackInterface
{
    override fun onChanged(email: String?)
    {
        userLocalDbProvider.saveEmail(db=null, email = email)
        userMail.postValue(userLocalDbProvider.getEmail(db=null))
    }
}