package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserShortcutsSocketCallbackInterface

class UserShortcutsSocketCallbackImpl(private val shortcutsData: MutableLiveData<ArrayList<Shortcut?>?>):
    UserShortcutsSocketCallbackInterface
{
    override fun onChanged(shortcuts: ArrayList<Shortcut?>?)
    {
        shortcutsData.postValue(shortcuts)
    }
}