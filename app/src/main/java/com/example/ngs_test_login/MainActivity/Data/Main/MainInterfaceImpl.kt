package com.example.ngs_test_login.MainActivity.Data.Main

import com.example.ngs_test_login.MainActivity.Data.Main.Web.GetData
import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface

class MainInterfaceImpl: MainInterface
{
    override fun getData()
    {
        val getData = GetData()
        val dataJson = getData.getData()
        val mainDataSerializer = MainDataSerializer(dataJson)
        val mainData: MainData = mainDataSerializer.doSerialization()
    }

}