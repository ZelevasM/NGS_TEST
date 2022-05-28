package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.UsersFoldersListsTable
import com.example.ngs_test_login.MainActivity.Domain.Models.User

class UsersFoldersListsTableManager
{
    fun write(user: User?, db: SQLiteDatabase?)
    {
        val folderListsValues: ContentValues = ContentValues()
        if(user?.folder != null)
        {
            for(i in user.folder!!.indices)
            {
                if(user.folder?.get(i)?.lists != null)
                {
                    Log.d("LocalDb", "FOLDER LISTS NULLNESS: ${user.folder?.get(i)?.lists}")
                    for(j in user.folder?.get(i)?.lists?.indices!!)
                    {
                      folderListsValues.put(UsersFoldersListsTable.FOLDERS_LISTS_COLUMN_NAME_KEY,user.folder?.get(i)?.id)
                      folderListsValues.put(UsersFoldersListsTable.FOLDERS_LISTS_COLUMN_NAME_ID, user.folder?.get(i)?.lists?.get(j))
                      db?.insert(UsersFoldersListsTable.FOLDERS_LISTS_TABLE_NAME, null, folderListsValues)
                    }
                }
            }
        }
    }

    @SuppressLint("Range")
    fun read(user: User?,db: SQLiteDatabase?): User?
    {
        val cursor = db?.query(UsersFoldersListsTable.FOLDERS_LISTS_TABLE_NAME, null, null, null,
            null, null, null)
        var key: String? = null
        var id: String? = null
        var i: Int = 0
        while(cursor?.moveToNext() == true)
        {
            key = cursor.getString(cursor.getColumnIndex(UsersFoldersListsTable.FOLDERS_LISTS_COLUMN_NAME_KEY))
            id = cursor.getString(cursor.getColumnIndex(UsersFoldersListsTable.FOLDERS_LISTS_COLUMN_NAME_ID))
            Log.d("LocalDb", "LIST# $i")
            Log.d("LocalDb", "${UsersFoldersListsTable.FOLDERS_LISTS_TABLE_NAME} KEY : $key")
            Log.d("LocalDb", "${UsersFoldersListsTable.FOLDERS_LISTS_TABLE_NAME} ID : $id")
            if(user?.folder != null)
            {
                for(k in user.folder?.indices!!)
                {
                    if(user.folder?.get(k)?.id == key)
                    {
                        user.folder?.get(k)?.lists?.add(id)
                        break
                    }
                }
            }
            i += 1
        }
        cursor?.close()

        return user
    }
}