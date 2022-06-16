package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserHomepageSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Presentation.User.LocalDbProviders.User

class UserHomepageSocketCallbackInterfaceImpl(private val homepageData: MutableLiveData<String?>,
                                            private val userLocalDbProvider: User)
    : UserHomepageSocketCallbackInterface
{
    override fun onChanged(homepage: String?)
    {
        userLocalDbProvider.saveHomepage(db=null, homepage = homepage)
        homepageData.postValue(userLocalDbProvider.getHomepage(db = null))
    }
}