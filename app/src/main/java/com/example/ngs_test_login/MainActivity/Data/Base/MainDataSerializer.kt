package com.example.ngs_test_login.MainActivity.Data.Base

import com.example.ngs_test_login.MainActivity.Data.Base.Models.WebMainData
import com.google.gson.Gson

class MainDataSerializer(private val dataJson: String?)
{
    //TODO Change to Generic version
    fun doSerialization(): WebMainData?
    {
        val gson = Gson()
        val webMainData: WebMainData? = gson.fromJson(dataJson, WebMainData::class.java)
        return webMainData
    }
}