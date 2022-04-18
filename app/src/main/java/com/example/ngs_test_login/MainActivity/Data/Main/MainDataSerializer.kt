package com.example.ngs_test_login.MainActivity.Data.Main

import com.google.gson.Gson

class MainDataSerializer(private val dataJson: String)
{
    fun doSerialization(): MainData
    {
        val gson = Gson()
        val mainData: MainData = gson.fromJson(dataJson, MainData::class.java)
        return mainData
    }
}