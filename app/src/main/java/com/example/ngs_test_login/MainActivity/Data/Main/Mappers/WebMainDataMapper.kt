package com.example.ngs_test_login.MainActivity.Data.Main.Mappers

import com.example.ngs_test_login.MainActivity.Data.Base.Models.WebMainData
import com.example.ngs_test_login.MainActivity.Domain.Main.Mappers.MainDataMapper
import com.example.ngs_test_login.MainActivity.Domain.Models.MainData

class WebMainDataMapper: MainDataMapper<WebMainData?, MainData?>
{
    override fun fromWebData(webMainData: WebMainData?): MainData?
    {
        return putData(webMainData)
    }

    private fun putData(webMainData: WebMainData?): MainData?
    {
        var mainData: MainData? = null
        if(webMainData != null)
        {
            mainData = MainData(
                dataLists = webMainData.dataLists,
                chats = webMainData.chats,
                user = webMainData.user)
        }
        return mainData
    }
}