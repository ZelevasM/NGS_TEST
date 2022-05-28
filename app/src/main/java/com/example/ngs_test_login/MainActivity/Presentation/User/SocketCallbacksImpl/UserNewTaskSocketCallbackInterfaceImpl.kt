package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserNewTaskSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Presentation.User.LocalDbProviders.UserLocalProvider

class UserNewTaskSocketCallbackInterfaceImpl(private val userNewTaskData: MutableLiveData<String?>,
                                        private val userLocalDbProvider: UserLocalProvider):
    UserNewTaskSocketCallbackInterface
{
    override fun onChanged(newTask: String?)
    {
        userLocalDbProvider.saveNewTask(db=null, newTask = newTask)
        userNewTaskData.postValue(userLocalDbProvider.getNewTask(db=null))
    }
}