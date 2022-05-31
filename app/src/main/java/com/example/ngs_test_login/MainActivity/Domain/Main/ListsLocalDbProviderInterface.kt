package com.example.ngs_test_login.MainActivity.Domain.Main

import com.example.ngs_test_login.MainActivity.Domain.Models.DataList

interface ListsLocalDbProviderInterface
{
    fun addLocalList(dataList: DataList,dataLists: ArrayList<DataList?>?)

    fun updateLocalList(dataList: DataList, dataLists: ArrayList<DataList?>?)

    fun deleteLocalList(dataList: DataList, dataLists: ArrayList<DataList?>?)

    fun getLocalList(dataList: DataList, dataLists: ArrayList<DataList?>?)
}