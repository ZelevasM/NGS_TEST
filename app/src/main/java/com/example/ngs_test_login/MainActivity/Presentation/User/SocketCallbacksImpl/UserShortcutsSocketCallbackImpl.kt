package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Data.User.Models.ShortcutWeb
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserShortcutsSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Presentation.User.LocalDbProviders.UserLocalProvider

class UserShortcutsSocketCallbackImpl (private val shortcutsData: MutableLiveData<ArrayList<ShortcutWeb?>?>,
                                       private val localUserDbProvider: UserLocalProvider):
    UserShortcutsSocketCallbackInterface
{
    override fun onChanged(shortcutWebs: ArrayList<ShortcutWeb?>?)
    {

        shortcutsData.postValue(shortcutWebs)
    }
}