package com.example.ngs_test_login.MainActivity.Data.Main.Local

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Domain.Models.User

class UserDatabaseManager private constructor(private val context: Context)
{
    private val userDatabaseHelper: UserDatabaseHelper = UserDatabaseHelper(context)
    private var db: SQLiteDatabase? = null

    companion object{
        @SuppressLint("StaticFieldLeak")
        private var instance: UserDatabaseManager? = null
        fun getInstance(context: Context) = synchronized(this)
        {
            if (instance == null)
                instance = UserDatabaseManager(context)
            instance
        }
    }
    fun openDb(): Boolean
    {
        var newlyCreated: Boolean = true
        if(db == null)
        {
            db = userDatabaseHelper.writableDatabase
        }
        else {newlyCreated = false}
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
        }
        db?.insert(UserDatabase.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun readFromDb()
    {
        val cursor = db?.query(UserDatabase.TABLE_NAME, null, null, null,
                        null, null, null)
        var i: Int = 0
        while(cursor?.moveToNext()!!)
        {
            val name: String = cursor.getString(cursor.getColumnIndex(UserDatabase.COLUMN_NAME_NAME))
            val email: String = cursor.getString(cursor.getColumnIndex(UserDatabase.COLUMN_NAME_EMAIL))
            Log.d("LocalDb", "User NAME $i: $name")
            Log.d("LocalDb", "User EMAIL $i: $email")
            i+=1
        }
        //close cursor
        cursor.close()
    }

    fun closeDb()
    {
        //close db helper
        userDatabaseHelper.close()
    }
}