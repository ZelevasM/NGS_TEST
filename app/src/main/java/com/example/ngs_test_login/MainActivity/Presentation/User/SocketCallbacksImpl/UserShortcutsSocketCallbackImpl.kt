package com.example.ngs_test_login.MainActivity.Presentation.User.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Data.User.Web.Models.ShortcutWeb
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserShortcutsSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Presentation.User.LocalDbProviders.User

class UserShortcutsSocketCallbackImpl (private val shortcutsData: MutableLiveData<ArrayList<ShortcutWeb?>?>,
                                       private val localUserDbProvider: User):
    UserShortcutsSocketCallbackInterface
{
    override fun onChanged(shortcutWebs: ArrayList<ShortcutWeb?>?)
    {

        shortcutsData.postValue(shortcutWebs)
    }
}