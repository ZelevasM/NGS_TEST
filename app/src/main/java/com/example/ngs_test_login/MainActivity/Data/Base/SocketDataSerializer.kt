package com.example.ngs_test_login.MainActivity.Data.Base

import com.google.gson.Gson
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