package com.example.ngs_test_login.MainActivity.Data.Main.Mappers

import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Main.WebMainData
import com.example.ngs_test_login.MainActivity.Domain.Main.Mappers.MainDataMapper
import com.example.ngs_test_login.MainActivity.Domain.Models.MainData

class WebMainDataMapper: MainDataMapper<WebMainData, MainData>
{
    override fun fromWebData(webMainData: WebMainData): MainData
    {
        return putData(webMainData)
    }

    private fun putData(webMainData: WebMainData): MainData
    {
        val mainData = MainData(
            dataLists = webMainData.dataLists,
            chats = webMainData.chats,
            user = webMainData.user)
        Log.d("MyLog", "MAIN_DATA: $mainData")
        return mainData
    }
}