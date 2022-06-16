package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.UsersFoldersListsTable
import com.example.ngs_test_login.MainActivity.Data.User.Models.UserWeb

class UsersFoldersListsTableManager
{
    fun write(userWeb: UserWeb?,db: SQLiteDatabase?)
    {
        val folderListsValues: ContentValues = ContentValues()
        if(userWeb?.folderWeb != null)
        {
            for(i in userWeb.folderWeb!!.indices)
            {
                if(userWeb.folderWeb?.get(i)?.lists != null)
                {
                    Log.d("LocalDb", "FOLDER LISTS NULLNESS: ${userWeb.folderWeb?.get(i)?.lists}")
                    for(j in userWeb.folderWeb?.get(i)?.lists?.indices!!)
                    {
                      folderListsValues.put(UsersFoldersListsTable.FOLDERS_LISTS_COLUMN_NAME_KEY,userWeb.folderWeb?.get(i)?.id)
                      folderListsValues.put(UsersFoldersListsTable.FOLDERS_LISTS_COLUMN_NAME_ID, userWeb.folderWeb?.get(i)?.lists?.get(j))
                      db?.insert(UsersFoldersListsTable.FOLDERS_LISTS_TABLE_NAME, null, folderListsValues)
                    }
                }
            }
        }
    }

    @SuppressLint("Range")
    fun read(userWeb: UserWeb?,db: SQLiteDatabase?): UserWeb?
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
            if(userWeb?.folderWeb != null)
            {
                for(k in userWeb.folderWeb?.indices!!)
                {
                    if(userWeb.folderWeb?.get(k)?.id == key)
                    {
                        userWeb.folderWeb?.get(k)?.lists?.add(id)
                        break
                    }
                }
            }
            i += 1
        }
        cursor?.close()

        return userWeb
    }
}