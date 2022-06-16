package com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks

import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList

interface ListSocketCallbackInterface
{
    fun onAdded(list: DataList?)

    fun onUpdated(list: DataList?)

    fun onDeleted(list: DataList?)
}