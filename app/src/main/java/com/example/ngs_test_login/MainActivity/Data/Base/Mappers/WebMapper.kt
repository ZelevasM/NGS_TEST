package com.example.ngs_test_login.MainActivity.Data.Base.Mappers

import com.example.ngs_test_login.MainActivity.Data.Base.Models.WebMainData
import com.example.ngs_test_login.MainActivity.Domain.Mappers.Mapper
import com.example.ngs_test_login.MainActivity.Domain.Base.Models.MainData

class WebMapper: Mapper<WebMainData?, MainData?>
{
    override fun map(webMainData: WebMainData?): MainData?
    {
        return putData(webMainData)
    }

    private fun putData(webMainData: WebMainData?): MainData?
    {
        var mainData: MainData? = null
        if(webMainData != null)
        {
            mainData = MainData(
                dataListWebs = webMainData.dataListWebs,
                chatWebs = webMainData.chatWebs,
                userWeb = webMainData.userWeb)
        }
        return mainData
    }
}