package com.example.ngs_test_login.MainActivity.Data.Main.Local

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Domain.Models.User

class UserDatabaseManager (private val context: Context)
{
    private val userDatabaseHelper: UserDatabaseHelper = UserDatabaseHelper(context)
    private var db: SQLiteDatabase? = null
    private var dbOpened: Boolean = true

    companion object{
        //@SuppressLint("StaticFieldLeak")
//        private var instance: UserDatabaseManager? = null
//        fun getInstance(context: Context) = synchronized(this)
//        {
//            if (instance == null)
//                instance = UserDatabaseManager(context)
//            instance
//        }
    }
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
    }

    @SuppressLint("Range")
    fun readFromDb(): User?
    {
        val cursor = db?.query(UserDatabase.TABLE_NAME, null, null, null,
                        null, null, null)
        var i: Int = 0
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
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME}$i NAME : $name")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME}$i ID : $id")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME}$i EMAIL : $email")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME}$i LANGUAGE : $language")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME}$i SIDEBAR : $sidebar")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME}$i DISK SPACE : $diskSpace")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME}$i EXPAND SUBTASK : $expandSubtask")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME}$i NEW TASK : $newTask")
            Log.d("LocalDb", "${UserDatabase.TABLE_NAME}$i SHORT INBOX : $shortInbox")
            i+=1
        }
        val user: User? = User(name = name, id = id, email = email, language = language,
        showSidebar = ConvertStringToBoolean(sidebar.toString()).convert(),
        diskSpace = diskSpace, expandSubtask = ConvertStringToBoolean(expandSubtask.toString()).convert(),
        newTask = ConvertStringToBoolean(newTask.toString()).convert(), shortcutInbox = shortInbox)
        //close cursor
        cursor?.close()
        return user
    }

    fun closeDb()
    {
        //close db helper
        userDatabaseHelper.close()
        dbOpened = false
    }
}