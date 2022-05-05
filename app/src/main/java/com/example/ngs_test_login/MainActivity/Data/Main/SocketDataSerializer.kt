package com.example.ngs_test_login.MainActivity.Data.Main

import com.example.ngs_test_login.MainActivity.Domain.Models.DataList
import com.google.gson.Gson
import com.google.gson.JsonParser
import org.json.JSONObject

class SocketDataSerializer <T> (private val listJson: JSONObject, private val generic: Class<T>)
{
    fun doSerialization(): T
    {
        val gson = Gson()
        val data: T = gson.fromJson(listJson.toString(), generic)
        return data
    }
}