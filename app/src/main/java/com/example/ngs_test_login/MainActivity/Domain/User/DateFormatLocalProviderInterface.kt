package com.example.ngs_test_login.MainActivity.Domain.User

import android.database.sqlite.SQLiteDatabase
import com.example.ngs_test_login.MainActivity.Domain.Models.User

interface DateFormatLocalProviderInterface
{
    fun saveDateFormat(vararg user: User?,db: SQLiteDatabase?,dateFormat: String?)

    fun getDateFormat(vararg user: User?,db: SQLiteDatabase?): String?

    fun saveTimeFormat(vararg user: User?,db: SQLiteDatabase?,timeFormat: String?)

    fun getTimeFormat(vararg user: User?,db: SQLiteDatabase?): String?

    fun saveStartOfWeek(vararg user: User?,db: SQLiteDatabase?,startOfWeek: String?)

    fun getStartOfWeek(vararg user: User?,db: SQLiteDatabase?): String?
}