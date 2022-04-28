package com.example.ngs_test_login.MainActivity.Data.Main.Web

import com.example.ngs_test_login.MainActivity.Data.Main.Models.SocketSendList
import com.google.gson.GsonBuilder
import org.json.JSONObject

class ConvertClassToJson <T> (private val dataObj: T)
{
    fun convert(): JSONObject
    {
        val gson = GsonBuilder().disableHtmlEscaping().create()
        val jsonString: String = gson.toJson(dataObj)
        val jsonObject: JSONObject = JSONObject(jsonString)
        return jsonObject
    }
}