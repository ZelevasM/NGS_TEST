package com.example.ngs_test_login.MainActivity.Domain.Main.Repositories

import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import io.socket.client.Socket

interface ListsRepository
{
    fun addLocalLists(dataLists: ArrayList<DataList?>?)

    fun getLocalLists(): ArrayList<DataList?>?

    fun addLocalList(dataList: DataList?)

    fun updateLocalList(dataList: DataList?)

    fun deleteLocalList(dataList: DataList?)

    fun getLocalList(dataList: DataList?): DataList?

    //Socket's Methods

    fun socketInit(bSocket: Socket)

    fun addList(name: String)

    fun updateList(id: String, newName: String)

    fun deleteList(id: String)

    fun getList(listSocketCallbackInterface: ListSocketCallbackInterface)
}