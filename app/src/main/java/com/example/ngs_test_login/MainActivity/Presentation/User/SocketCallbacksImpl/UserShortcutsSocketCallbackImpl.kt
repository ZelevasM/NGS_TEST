package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserShortcutsSocketCallbackInterface

class UserShortcutsSocketCallbackImpl (private val shortcutsData: MutableLiveData<ArrayList<Shortcut?>?>,
                                       private val userRepository: UserRepository):
    UserShortcutsSocketCallbackInterface
{
    override fun onChanged(shortcuts: ArrayList<Shortcut?>?)
    {

        shortcutsData.postValue(shortcuts)
    }
}