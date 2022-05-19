package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalUserDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Main.Local.ConvertStringToBoolean
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalUserDb.Tables.UserTable
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalUserDb.UserDatabase
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalUserDb.UserDatabaseHelper
import com.example.ngs_test_login.MainActivity.Domain.Models.User

class UserTableManager()
{
    fun write(user: User?, db: SQLiteDatabase?)
    {
        val values: ContentValues = ContentValues().apply {
            put(UserTable.COLUMN_NAME_NAME, user?.name)
            put(UserTable.COLUMN_NAME_ID, user?.id)
            put(UserTable.COLUMN_NAME_EMAIL, user?.email)
            put(UserTable.COLUMN_NAME_LANGUAGE, user?.language)
            put(UserTable.COLUMN_NAME_SIDEBAR, user?.showSidebar)
            put(UserTable.COLUMN_NAME_DISK_SPACE, user?.diskSpace)
            put(UserTable.COLUMN_NAME_EXPAND_SUBTASK, user?.expandSubtask)
            put(UserTable.COLUMN_NAME_NEW_TASK, user?.newTask)
            put(UserTable.COLUMN_NAME_SHORTCUT_INBOX, user?.shortcutInbox)
        }
        db?.insert(UserTable.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun read(db: SQLiteDatabase?): User?
    {
        val cursor: Cursor? = db?.query(UserTable.TABLE_NAME, null, null, null,
            null, null, null)
        var name: String? = null
        var id: String? = null
        var email: String? = null
        var language: String? = null
        var sidebar: String? = null
        var diskSpace: String? = null
        var expandSubtask: String? = null
        var newTask: String? = null
        var shortInbox: String? = null
        while(cursor?.moveToNext() == true)
        {
            name = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_NAME))
            id = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_ID))
            email = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_EMAIL))
            language = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_LANGUAGE))
            sidebar = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_SIDEBAR))
            diskSpace = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_DISK_SPACE))
            expandSubtask = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_EXPAND_SUBTASK))
            newTask = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_NEW_TASK))
            shortInbox = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_SHORTCUT_INBOX))
            Log.d("LocalDb", "${UserTable.TABLE_NAME} NAME : $name")
            Log.d("LocalDb", "${UserTable.TABLE_NAME} ID : $id")
            Log.d("LocalDb", "${UserTable.TABLE_NAME} EMAIL : $email")
            Log.d("LocalDb", "${UserTable.TABLE_NAME} LANGUAGE : $language")
            Log.d("LocalDb", "${UserTable.TABLE_NAME} SIDEBAR : $sidebar")
            Log.d("LocalDb", "${UserTable.TABLE_NAME} DISK SPACE : $diskSpace")
            Log.d("LocalDb", "${UserTable.TABLE_NAME} EXPAND SUBTASK : $expandSubtask")
            Log.d("LocalDb", "${UserTable.TABLE_NAME} NEW TASK : $newTask")
            Log.d("LocalDb", "${UserTable.TABLE_NAME} SHORT INBOX : $shortInbox\n=")
        }
        cursor?.close()

        val user: User? = User(name = name, id = id, email = email, language = language,
            showSidebar = ConvertStringToBoolean(sidebar.toString()).convert(),
            diskSpace = diskSpace, expandSubtask = ConvertStringToBoolean(expandSubtask.toString()).convert(),
            newTask = ConvertStringToBoolean(newTask.toString()).convert(), shortcutInbox = shortInbox)
//        user?.name = name
//        user?.id = id
//        user?.email = email
//        user?.language = language
//        user?.showSidebar = ConvertStringToBoolean(sidebar.toString()).convert()
//        user?.diskSpace = diskSpace
//        user?.expandSubtask = ConvertStringToBoolean(expandSubtask.toString()).convert()
//        user?.newTask = ConvertStringToBoolean(newTask.toString()).convert()
//        user?.shortcutInbox = shortInbox
        return user
    }
}