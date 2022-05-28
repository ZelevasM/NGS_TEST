package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import androidx.core.content.contentValuesOf
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.UsersDateFormatsTable
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.UsersFoldersListsTable
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.UsersTable
import com.example.ngs_test_login.MainActivity.Domain.Models.DateFormat
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.DateFormatLocalProviderInterface

class UsersDateFormatsTableManager: DateFormatLocalProviderInterface
{
    fun write(user: User?,db: SQLiteDatabase?)
    {
        val dateFormatValues: ContentValues = ContentValues()
        if(user?.dateFormat != null)
        {
            dateFormatValues.put(UsersDateFormatsTable.COLUMN_NAME_KEY, user.id)
            dateFormatValues.put(UsersDateFormatsTable.COLUMN_NAME_DATE, user.dateFormat?.date)
            dateFormatValues.put(UsersDateFormatsTable.COLUMN_NAME_START_OF_WEEK, user.dateFormat?.startOfTheWeek)
            dateFormatValues.put(UsersDateFormatsTable.COLUMN_NAME_TIME, user.dateFormat?.time)
            db?.insert(UsersDateFormatsTable.TABLE_NAME, null, dateFormatValues)
        }
    }

    @SuppressLint("Range")
    fun read(user: User?,db: SQLiteDatabase?): User?
    {
        val cursor = db?.query(UsersFoldersListsTable.FOLDERS_LISTS_TABLE_NAME,
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
        var dateFormat: DateFormat? = null
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
            if(user?.id == key)
            {
                dateFormat = DateFormat(date, startOfWeek, time)
            }
        }
        cursor?.close()
        user?.dateFormat = dateFormat
        return user
    }

    override fun saveDateFormat(vararg user: User?,db: SQLiteDatabase?,dateFormat: String?)
    {
        val id: String? = user[0]?.id
        db?.update(UsersDateFormatsTable.TABLE_NAME, contentValuesOf(
            UsersDateFormatsTable.COLUMN_NAME_DATE to dateFormat),
            "${UsersDateFormatsTable.COLUMN_NAME_KEY} = ?",arrayOf(id))
    }

    @SuppressLint("Range")
    override fun getDateFormat(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val id: String? = user[0]?.id

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

    override fun saveTimeFormat(vararg user: User?,db: SQLiteDatabase?,timeFormat: String?)
    {
        val id: String? = user[0]?.id
        db?.update(UsersDateFormatsTable.TABLE_NAME, contentValuesOf(
            UsersDateFormatsTable.COLUMN_NAME_TIME to timeFormat),
            "${UsersDateFormatsTable.COLUMN_NAME_KEY} = ?",arrayOf(id))
    }

    @SuppressLint("Range")
    override fun getTimeFormat(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val id: String? = user[0]?.id

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

    override fun saveStartOfWeek(vararg user: User?,db: SQLiteDatabase?,startOfWeek: String?)
    {
        val id: String? = user[0]?.id
        db?.update(UsersDateFormatsTable.TABLE_NAME, contentValuesOf(
            UsersDateFormatsTable.COLUMN_NAME_START_OF_WEEK to startOfWeek),
            "${UsersDateFormatsTable.COLUMN_NAME_KEY} = ?",arrayOf(id))
    }

    @SuppressLint("Range")
    override fun getStartOfWeek(vararg user: User?,db: SQLiteDatabase?): String?
    {
        val id: String? = user[0]?.id

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