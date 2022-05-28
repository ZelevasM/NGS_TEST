package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.UsersFoldersListsTable
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.UsersShortcutsTable
import com.example.ngs_test_login.MainActivity.Domain.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.Models.User

class UsersShortcutsTableManager
{
    fun write(user: User?,db: SQLiteDatabase?)
    {
        val shortcutsValues: ContentValues = ContentValues()
        if(user?.shortcuts != null)
        {
            for(i in user.shortcuts?.indices!!)
            {
                shortcutsValues.put(UsersShortcutsTable.COLUMN_NAME_KEY, user.id)
                shortcutsValues.put(UsersShortcutsTable.COLUMN_NAME_COLOR, user.shortcuts?.get(i)?.color)
                shortcutsValues.put(UsersShortcutsTable.COLUMN_NAME_TYPE, user.shortcuts?.get(i)?.type)
                shortcutsValues.put(UsersShortcutsTable.COLUMN_NAME_PROJECT_ID, user.shortcuts?.get(i)?.projectId)
                db?.insert(UsersShortcutsTable.TABLE_NAME, null, shortcutsValues)
            }
        }
    }

    @SuppressLint("Range")
    fun read(user: User?,db: SQLiteDatabase?): User?
    {
        val cursor = db?.query(UsersShortcutsTable.TABLE_NAME, null, null, null,
            null, null, null)
        var key: String? = null
        var color: String? = null
        var type: String? = null
        var projectId: String? = null
        var shortcuts: ArrayList<Shortcut?>? = ArrayList()
        var shortcut: Shortcut? = null
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
            if(user?.id == key)
            {
                shortcuts?.add(Shortcut(color = color, type = type, projectId = projectId))
            }
            i += 1
        }
        cursor?.close()
        user?.shortcuts = shortcuts
        return user
    }
}