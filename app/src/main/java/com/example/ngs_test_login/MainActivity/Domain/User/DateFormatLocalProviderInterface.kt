package com.example.ngs_test_login.MainActivity.Domain.User

import android.database.sqlite.SQLiteDatabase
import com.example.ngs_test_login.MainActivity.Data.User.Models.UserWeb

interface DateFormatLocalProviderInterface
{
    fun saveDateFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?,dateFormat: String?)

    fun getDateFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?

    fun saveTimeFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?,timeFormat: String?)

    fun getTimeFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?

    fun saveStartOfWeek(vararg userWeb: UserWeb?,db: SQLiteDatabase?,startOfWeek: String?)

    fun getStartOfWeek(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
}