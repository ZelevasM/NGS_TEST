package com.example.ngs_test_login.MainActivity.Domain.User.Repositories

import com.example.ngs_test_login.MainActivity.Domain.User.Models.User

interface DateFormatRepository
{
    fun saveDateFormat(dateFormat: String?)

    fun getDateFormat(): String?

    fun saveTimeFormat(timeFormat: String?)

    fun getTimeFormat(): String?

    fun saveStartOfWeek(startOfWeek: String?)

    fun getStartOfWeek(): String?
}