package com.example.ngs_test_login.MainActivity.Data.Main

import android.util.Log
import com.google.gson.Gson

class MainDataSerializer(private val dataJson: String)
{
    fun doSerialization(): MainData
    {
        val gson = Gson()
        val mainData:  MainData = gson.fromJson(dataJson, MainData::class.java)
        Log.d("MyLog", "MAINDATA: $mainData")
        return mainData
    }
}