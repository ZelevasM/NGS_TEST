package com.example.ngs_test_login.MainActivity.Data.Main.Web

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class IdGenerator(private val id: String)
{
//    private val TIME_DATE_PATTERN: String = "EE MMM dd yyyy hh:mm:ss z"
//    Result is : Thu Apr 28 2022 11:17:18 GMT+05:00
//    private val locale: Locale = Locale.getDefault()
//    private val dateFormat: SimpleDateFormat = SimpleDateFormat(TIME_DATE_PATTERN, locale)
//    val date: Date = Date()

    @RequiresApi(Build.VERSION_CODES.O)
    fun generate(): String
    {
        //val currentTime: String = dateFormat.format(date)
        val timeD: Long = System.currentTimeMillis()
        val bundle = "$timeD" + "_$id"
        //val bundleArray: Array<String> = bundle.toCharArray().map { it.toString() }.toTypedArray()
        val encodedBundle: String = Base64.getEncoder().encodeToString(bundle.toByteArray())

        Log.d("MyLog","Bundle of ID: $encodedBundle")
        return encodedBundle
    }

}