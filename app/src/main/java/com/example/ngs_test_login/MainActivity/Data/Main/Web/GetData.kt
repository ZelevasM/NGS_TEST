package com.example.ngs_test_login.MainActivity.Data.Main.Web

import android.util.Log
import com.example.ngs_test_login.BuildConfig
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class GetData
{
    private val dataURL = URL(BuildConfig.GET_DATA)
    private lateinit var httpURLConnection: HttpURLConnection

    fun getData(): String
    {
        var dataJson: String = "{}"
        httpURLConnection = dataURL.openConnection() as HttpURLConnection
        httpURLConnection.addRequestProperty("Authorization",BuildConfig.Token)
        httpURLConnection.requestMethod = "GET"
        Log.d("MyLog","Before Res ${httpURLConnection.responseCode}")
        if(httpURLConnection.responseCode in 200..299)
        {
            BufferedReader(InputStreamReader(httpURLConnection.inputStream)).use {
                val inputLine = it.readLine()
                dataJson = inputLine
                Log.d("MyLog","RES_LISTS: $dataJson")
            }
        }
        if (httpURLConnection.responseCode in 300..600)
        {
            Log.d("MyLog","ERRORCODE: ${httpURLConnection.responseCode}")
        }
        httpURLConnection.disconnect()
        return dataJson
    }
}