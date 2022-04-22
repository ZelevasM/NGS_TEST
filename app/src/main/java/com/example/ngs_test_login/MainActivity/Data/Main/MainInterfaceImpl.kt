package com.example.ngs_test_login.MainActivity.Data.Main

import com.example.ngs_test_login.MainActivity.Data.Main.Mappers.WebMainDataMapper
import com.example.ngs_test_login.MainActivity.Data.Main.Web.GetData
import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.MainData

class MainInterfaceImpl: MainInterface
{
    override fun getData(): MainData
    {
        val getData = GetData()
        val dataJson = getData.getData()
        val mainDataSerializer: MainDataSerializer = MainDataSerializer(dataJson)
        val webMainData: WebMainData = mainDataSerializer.doSerialization()
        val webMainDataMapper: WebMainDataMapper = WebMainDataMapper()
        val mainData: MainData = webMainDataMapper.fromWebData(webMainData)
        return mainData
    }

}