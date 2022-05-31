package com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks

import com.example.ngs_test_login.MainActivity.Domain.Models.DataList
import com.example.ngs_test_login.MainActivity.Domain.Models.SocketList

interface ListSocketCallbackInterface
{
    fun onAdded(list: DataList)

    fun onUpdated(list: DataList)

    fun onDeleted(list: DataList)
}