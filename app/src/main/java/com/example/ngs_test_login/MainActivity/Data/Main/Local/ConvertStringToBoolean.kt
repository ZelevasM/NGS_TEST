package com.example.ngs_test_login.MainActivity.Data.Main.Local

class ConvertStringToBoolean (private val string: String)
{
    fun convert(): Boolean
    {
        val boolean: Boolean = string.toBoolean()
        return boolean
    }
}