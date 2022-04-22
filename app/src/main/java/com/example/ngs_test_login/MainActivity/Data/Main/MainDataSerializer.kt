package com.example.ngs_test_login.MainActivity.Data.Main

import android.util.Log
import com.google.gson.Gson

class MainDataSerializer(private val dataJson: String)
{
    fun doSerialization(): WebMainData
    {
        val gson = Gson()
        val webMainData:  WebMainData = gson.fromJson(dataJson, WebMainData::class.java)
        Log.d("MyLog", "WEB_MAIN_DATA: $webMainData")
        return webMainData
    }
}