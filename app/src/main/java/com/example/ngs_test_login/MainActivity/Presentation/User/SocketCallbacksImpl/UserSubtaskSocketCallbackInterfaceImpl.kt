package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserSubtaskSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Presentation.User.LocalDbProviders.User

class UserSubtaskSocketCallbackInterfaceImpl(private val expandSubtask: MutableLiveData<String?>,
                                        private val userLocalDbProvider: User):
    UserSubtaskSocketCallbackInterface
{
    override fun onChanged(subTask: String?)
    {
        userLocalDbProvider.saveExpandSubtask(db=null, expandSubtask = subTask)
        expandSubtask.postValue(userLocalDbProvider.getExpandSubtask(db=null))
    }
}