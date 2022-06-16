package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import androidx.core.content.contentValuesOf
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.UsersDateFormatsTable
import com.example.ngs_test_login.MainActivity.Data.User.Models.DateFormatWeb
import com.example.ngs_test_login.MainActivity.Data.User.Models.UserWeb
import com.example.ngs_test_login.MainActivity.Domain.User.DateFormatLocalProviderInterface

class UsersDateFormatsTableManager: DateFormatLocalProviderInterface
{
    fun write(userWeb: UserWeb?,db: SQLiteDatabase?)
    {
        val dateFormatValues: ContentValues = ContentValues()
        if(userWeb?.dateFormatWeb != null)
        {
            dateFormatValues.put(UsersDateFormatsTable.COLUMN_NAME_KEY, userWeb.id)
            dateFormatValues.put(UsersDateFormatsTable.COLUMN_NAME_DATE, userWeb.dateFormatWeb?.date)
            dateFormatValues.put(UsersDateFormatsTable.COLUMN_NAME_START_OF_WEEK, userWeb.dateFormatWeb?.startOfTheWeek)
            dateFormatValues.put(UsersDateFormatsTable.COLUMN_NAME_TIME, userWeb.dateFormatWeb?.time)
            db?.insert(UsersDateFormatsTable.TABLE_NAME, null, dateFormatValues)
        }
    }

    @SuppressLint("Range")
    fun read(userWeb: UserWeb?,db: SQLiteDatabase?): UserWeb?
    {
        val cursor = db?.query(UsersDateFormatsTable.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null)
        var key: String? = null
        var date: String? = null
        var startOfWeek: String? = null
        var time: String? = null
        var i: Int = 0
        var dateFormatWeb: DateFormatWeb? = null
        while (cursor?.moveToNext() == true)
        {
            key = cursor.getString(cursor.getColumnIndex(UsersDateFormatsTable.COLUMN_NAME_KEY))
            date = cursor.getString(cursor.getColumnIndex(UsersDateFormatsTable.COLUMN_NAME_DATE))
            startOfWeek = cursor.getString(cursor.getColumnIndex(UsersDateFormatsTable.COLUMN_NAME_START_OF_WEEK))
            time = cursor.getString(cursor.getColumnIndex(UsersDateFormatsTable.COLUMN_NAME_TIME))
            Log.d("LocalDb","DATE FORMAT# $i")
            Log.d("LocalDb","${UsersDateFormatsTable.TABLE_NAME} KEY : $key")
            Log.d("LocalDb","${UsersDateFormatsTable.TABLE_NAME} DATE : $date")
            Log.d("LocalDb","${UsersDateFormatsTable.TABLE_NAME} START OF WEEK : $startOfWeek")
            Log.d("LocalDb","${UsersDateFormatsTable.TABLE_NAME} TIME : $time")
            i += 1
            if(userWeb?.id == key)
            {
                dateFormatWeb = DateFormatWeb(date, startOfWeek, time)
            }
        }
        cursor?.close()
        userWeb?.dateFormatWeb = dateFormatWeb
        return userWeb
    }

    override fun saveDateFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?,dateFormat: String?)
    {
        val id: String? = userWeb[0]?.id
        db?.update(UsersDateFormatsTable.TABLE_NAME, contentValuesOf(
            UsersDateFormatsTable.COLUMN_NAME_DATE to dateFormat),
            "${UsersDateFormatsTable.COLUMN_NAME_KEY} = ?",arrayOf(id))
    }

    @SuppressLint("Range")
    override fun getDateFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        val id: String? = userWeb[0]?.id

        val cursor: Cursor? = db?.query(UsersDateFormatsTable.TABLE_NAME,
            arrayOf(UsersDateFormatsTable.COLUMN_NAME_DATE),
            "${UsersDateFormatsTable.COLUMN_NAME_KEY} = ?",arrayOf(id),
            null, null, null)

        cursor?.moveToFirst()
        val dateFormat: String? = cursor?.getString(cursor.getColumnIndex(
            UsersDateFormatsTable.COLUMN_NAME_DATE))
        Log.d("LocalDb", "DATEFOOORMAT: $dateFormat")
        cursor?.close()

        return dateFormat
    }

    override fun saveTimeFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?,timeFormat: String?)
    {
        val id: String? = userWeb[0]?.id
        db?.update(UsersDateFormatsTable.TABLE_NAME, contentValuesOf(
            UsersDateFormatsTable.COLUMN_NAME_TIME to timeFormat),
            "${UsersDateFormatsTable.COLUMN_NAME_KEY} = ?",arrayOf(id))
    }

    @SuppressLint("Range")
    override fun getTimeFormat(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        val id: String? = userWeb[0]?.id

        val cursor: Cursor? = db?.query(UsersDateFormatsTable.TABLE_NAME,
            arrayOf(UsersDateFormatsTable.COLUMN_NAME_TIME),
            "${UsersDateFormatsTable.COLUMN_NAME_KEY} = ?",arrayOf(id),
            null, null, null)

        cursor?.moveToFirst()
        val timeFormat: String? = cursor?.getString(cursor.getColumnIndex(
            UsersDateFormatsTable.COLUMN_NAME_TIME))
        Log.d("LocalDb", "TIIIMEFOOORMAT: $timeFormat")
        cursor?.close()

        return timeFormat
    }

    override fun saveStartOfWeek(vararg userWeb: UserWeb?,db: SQLiteDatabase?,startOfWeek: String?)
    {
        val id: String? = userWeb[0]?.id
        db?.update(UsersDateFormatsTable.TABLE_NAME, contentValuesOf(
            UsersDateFormatsTable.COLUMN_NAME_START_OF_WEEK to startOfWeek),
            "${UsersDateFormatsTable.COLUMN_NAME_KEY} = ?",arrayOf(id))
    }

    @SuppressLint("Range")
    override fun getStartOfWeek(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    {
        val id: String? = userWeb[0]?.id

        val cursor: Cursor? = db?.query(UsersDateFormatsTable.TABLE_NAME,
            arrayOf(UsersDateFormatsTable.COLUMN_NAME_START_OF_WEEK),
            "${UsersDateFormatsTable.COLUMN_NAME_KEY} = ?",arrayOf(id),
            null, null, null)

        cursor?.moveToFirst()
        val startOfWeek: String? = cursor?.getString(cursor.getColumnIndex(
            UsersDateFormatsTable.COLUMN_NAME_START_OF_WEEK))
        Log.d("LocalDb", "STAAART OF WEEEEK: $startOfWeek")
        cursor?.close()

        return startOfWeek
    }
}