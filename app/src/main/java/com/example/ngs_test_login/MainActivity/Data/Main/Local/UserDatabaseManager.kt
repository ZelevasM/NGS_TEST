package com.example.ngs_test_login.MainActivity.Data.Main.Local

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Domain.Models.User

class UserDatabaseManager (private val context: Context)
{
    private val userDatabaseHelper: UserDatabaseHelper = UserDatabaseHelper(context)
    private var db: SQLiteDatabase? = null

    fun openDb(): Boolean
    {
        //TODO SUPER MEGA GOVNO CODE -> CHANGE IT
        var newlyCreated: Boolean = true

        db = userDatabaseHelper.writableDatabase
        //userDatabaseHelper.onUpgrade(db, UserDatabase.DATABASE_VERSION, UserDatabase.DATABASE_VERSION)

        if(db != null){newlyCreated = false}
        Log.d("LocalDb", "DB NEW: $newlyCreated")
        return newlyCreated
    }

    fun writeToDb(user: User?)
    {
        userDatabaseHelper.onUpgrade(db, UserDatabase.DATABASE_VERSION, UserDatabase.DATABASE_VERSION)
        val values: ContentValues = ContentValues().apply {
            put(UserDatabase.COLUMN_NAME_NAME, user?.name)
            put(UserDatabase.COLUMN_NAME_ID, user?.id)
            put(UserDatabase.COLUMN_NAME_EMAIL, user?.email)
            put(UserDatabase.COLUMN_NAME_LANGUAGE, user?.language)
            put(UserDatabase.COLUMN_NAME_SIDEBAR, user?.showSidebar)
            put(UserDatabase.COLUMN_NAME_DISK_SPACE, user?.diskSpace)
            put(UserDatabase.COLUMN_NAME_EXPAND_SUBTASK, user?.expandSubtask)
            put(UserDatabase.COLUMN_NAME_NEW_TASK, user?.newTask)
            put(UserDatabase.COLUMN_NAME_SHORTCUT_INBOX, user?.shortcutInbox)
        }
        db?.insert(UserDatabase.TABLE_NAME, null, values)

        //Write Values For Folders
        val folderValues: ContentValues = ContentValues()
        if(user?.folder != null)
        {
            Log.d("LocalDb", "SIZE: ${user.folder.size}")
            for(i in user.folder.indices)
            {
                folderValues.put(UserDatabase.FOLDERS_COLUMN_NAME_KEY,user.id)
                folderValues.put(UserDatabase.FOLDERS_COLUMN_NAME_ID, user.folder[i]?.id)
                folderValues.put(UserDatabase.FOLDERS_COLUMN_NAME_NAME, user.folder[i]?.name)
                folderValues.put(UserDatabase.FOLDERS_COLUMN_NAME_ORDER, user.folder[i]?.order)
                db?.insert(UserDatabase.FOLDERS_TABLE_NAME, null, folderValues)
            }
        }

        //Write Values For Lists in Folders
        val folderListsValues: ContentValues = ContentValues()
        if(user?.folder != null)
        {
            for(i in user.folder.indices)
            {
                if(user.folder[i]?.lists != null)
                {
                    Log.d("LocalDb", "FOLDER LISTS NULLNESS: ${user.folder[i]?.lists}")
                    for(j in user.folder[i]?.lists?.indices!!)
                    {
                        folderListsValues.put(UserDatabase.FOLDERS_LISTS_COLUMN_NAME_KEY,user.folder[i]?.id)
                        folderListsValues.put(UserDatabase.FOLDERS_LISTS_COLUMN_NAME_ID, user.folder[i]?.lists?.get(j))
                        db?.insert(UserDatabase.FOLDERS_LISTS_TABLE_NAME, null, folderListsValues)
                    }
                }
            }
        }
    }

    @SuppressLint("Range")
    fun readFromDb(): User?
    {
        var cursor: Cursor? = db?.query(UserDatabase.TABLE_NAME, null, null, null,
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
            name = cursor.getString(cursor.getColumnIndex(UserDatabase.COLUMN_NAME_NAME))
            id = cursor.getString(cursor.getColumnIndex(UserDatabase.COLUMN_NAME_ID))
            email = cursor.getString(cursor.getColumnIndex(UserDatabase.COLUMN_NAME_EMAIL))
            language = cursor.getString(cursor.getColumnIndex(UserDatabase.COLUMN_NAME_LANGUAGE))
            sidebar = cursor.getString(cursor.getColumnIndex(UserDatabase.COLUMN_NAME_SIDEBAR))
            diskSpace = cursor.getString(cursor.getColumnIndex(UserDatabase.COLUMN_NAME_DISK_SPACE))
            expandSubtask = cursor.getString(cursor.getColumnIndex(UserDatabase.COLUMN_NAME_EXPAND_SUBTASK))
            newTask = cursor.getString(cursor.getColumnIndex(UserDatabase.COLUMN_NAME_NEW_TASK))
            shortInbox = cursor.getString(cursor.getColumnIndex(UserDatabase.COLUMN_NAME_SHORTCUT_INBOX))
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME} NAME : $name")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME} ID : $id")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME} EMAIL : $email")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME} LANGUAGE : $language")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME} SIDEBAR : $sidebar")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME} DISK SPACE : $diskSpace")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME} EXPAND SUBTASK : $expandSubtask")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME} NEW TASK : $newTask")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME} SHORT INBOX : $shortInbox\n=")
        }

        val user: User? = User(name = name, id = id, email = email, language = language,
            showSidebar = ConvertStringToBoolean(sidebar.toString()).convert(),
            diskSpace = diskSpace, expandSubtask = ConvertStringToBoolean(expandSubtask.toString()).convert(),
            newTask = ConvertStringToBoolean(newTask.toString()).convert(), shortcutInbox = shortInbox)

        cursor = db?.query(UserDatabase.FOLDERS_TABLE_NAME, null, null, null,
                null, null, null)

        var key: String? = null
        var order: String? = null
        var i: Int = 0
        while(cursor?.moveToNext() == true)
        {
            key = cursor.getString(cursor.getColumnIndex(UserDatabase.FOLDERS_COLUMN_NAME_KEY))
            id = cursor.getString(cursor.getColumnIndex(UserDatabase.FOLDERS_COLUMN_NAME_ID))
            name = cursor.getString(cursor.getColumnIndex(UserDatabase.FOLDERS_COLUMN_NAME_NAME))
            order = cursor.getString(cursor.getColumnIndex(UserDatabase.FOLDERS_COLUMN_NAME_ORDER))
            Log.d("LocalDb", "${UserDatabase.FOLDERS_TABLE_NAME} KEY : $key")
            Log.d("LocalDb", "${UserDatabase.FOLDERS_TABLE_NAME} ID : $id")
            Log.d("LocalDb", "${UserDatabase.FOLDERS_TABLE_NAME} NAME : $name")
            Log.d("LocalDb", "${UserDatabase.FOLDERS_TABLE_NAME} ORDER : $order")
            Log.d("LocalDb", "READ ITERATION: $i \n=")
            i+=1
        }

        cursor = db?.query(UserDatabase.FOLDERS_LISTS_TABLE_NAME, null, null, null,
            null, null, null)
        i = 0
        while(cursor?.moveToNext() == true)
        {
            key = cursor.getString(cursor.getColumnIndex(UserDatabase.FOLDERS_LISTS_COLUMN_NAME_KEY))
            id = cursor.getString(cursor.getColumnIndex(UserDatabase.FOLDERS_LISTS_COLUMN_NAME_ID))
            Log.d("LocalDb", "LIST# $i")
            Log.d("LocalDb", "${UserDatabase.FOLDERS_LISTS_TABLE_NAME} KEY : $key")
            Log.d("LocalDb", "${UserDatabase.FOLDERS_LISTS_TABLE_NAME} ID : $id")
            i+=1
        }


        //close cursor
        cursor?.close()
        return user
    }

    fun closeDb()
    {
        //close db helper
        userDatabaseHelper.close()
    }
}