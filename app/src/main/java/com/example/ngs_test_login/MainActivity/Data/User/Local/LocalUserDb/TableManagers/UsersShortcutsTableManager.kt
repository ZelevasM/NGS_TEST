package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.UsersShortcutsTable
import com.example.ngs_test_login.MainActivity.Data.User.Models.ShortcutWeb
import com.example.ngs_test_login.MainActivity.Data.User.Models.UserWeb

class UsersShortcutsTableManager
{
    fun write(userWeb: UserWeb?,db: SQLiteDatabase?)
    {
        val shortcutsValues: ContentValues = ContentValues()
        if(userWeb?.shortcutWebs != null)
        {
            for(i in userWeb.shortcutWebs?.indices!!)
            {
                shortcutsValues.put(UsersShortcutsTable.COLUMN_NAME_KEY, userWeb.id)
                shortcutsValues.put(UsersShortcutsTable.COLUMN_NAME_COLOR, userWeb.shortcutWebs?.get(i)?.color)
                shortcutsValues.put(UsersShortcutsTable.COLUMN_NAME_TYPE, userWeb.shortcutWebs?.get(i)?.type)
                shortcutsValues.put(UsersShortcutsTable.COLUMN_NAME_PROJECT_ID, userWeb.shortcutWebs?.get(i)?.projectId)
                db?.insert(UsersShortcutsTable.TABLE_NAME, null, shortcutsValues)
            }
        }
    }

    @SuppressLint("Range")
    fun read(userWeb: UserWeb?,db: SQLiteDatabase?): UserWeb?
    {
        val cursor = db?.query(UsersShortcutsTable.TABLE_NAME, null, null, null,
            null, null, null)
        var key: String? = null
        var color: String? = null
        var type: String? = null
        var projectId: String? = null
        var shortcutWebs: ArrayList<ShortcutWeb?>? = ArrayList()
        var shortcutWeb: ShortcutWeb? = null
        var i: Int = 0
        while(cursor?.moveToNext() == true)
        {
            key = cursor.getString(cursor.getColumnIndex(UsersShortcutsTable.COLUMN_NAME_KEY))
            color = cursor.getString(cursor.getColumnIndex(UsersShortcutsTable.COLUMN_NAME_COLOR))
            type = cursor.getString(cursor.getColumnIndex(UsersShortcutsTable.COLUMN_NAME_TYPE))
            projectId = cursor.getString(cursor.getColumnIndex(UsersShortcutsTable.COLUMN_NAME_PROJECT_ID))
            Log.d("LocalDb", "SHORTCUT# $i")
            Log.d("LocalDb", "${UsersShortcutsTable.TABLE_NAME} KEY : $key")
            Log.d("LocalDb", "${UsersShortcutsTable.TABLE_NAME} COLOR : $color")
            Log.d("LocalDb", "${UsersShortcutsTable.TABLE_NAME} TYPE : $type")
            Log.d("LocalDb", "${UsersShortcutsTable.TABLE_NAME} PROJECT ID : $projectId")
            if(userWeb?.id == key)
            {
                shortcutWebs?.add(ShortcutWeb(color = color, type = type, projectId = projectId))
            }
            i += 1
        }
        cursor?.close()
        userWeb?.shortcutWebs = shortcutWebs
        return userWeb
    }
}