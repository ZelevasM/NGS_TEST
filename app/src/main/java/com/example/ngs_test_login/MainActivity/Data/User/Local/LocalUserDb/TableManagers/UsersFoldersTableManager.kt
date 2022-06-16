package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.UsersFoldersTable
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.FolderWeb
import com.example.ngs_test_login.MainActivity.Data.User.Models.UserWeb

class UsersFoldersTableManager
{
    fun write(userWeb: UserWeb?,db: SQLiteDatabase?)
    {
        val folderValues: ContentValues = ContentValues()
        if(userWeb?.folderWeb != null)
        {
            Log.d("LocalDb", "SIZE: ${userWeb.folderWeb?.size}")
            for(i in userWeb.folderWeb?.indices!!)
            {
                folderValues.put(UsersFoldersTable.FOLDERS_COLUMN_NAME_KEY,userWeb.id)
                folderValues.put(UsersFoldersTable.FOLDERS_COLUMN_NAME_ID, userWeb.folderWeb?.get(i)?.id)
                folderValues.put(UsersFoldersTable.FOLDERS_COLUMN_NAME_NAME, userWeb.folderWeb?.get(i)?.name)
                folderValues.put(UsersFoldersTable.FOLDERS_COLUMN_NAME_ORDER, userWeb.folderWeb?.get(i)?.order)
                db?.insert(UsersFoldersTable.FOLDERS_TABLE_NAME, null, folderValues)
            }
        }
    }

    @SuppressLint("Range")
    fun read(userWeb: UserWeb?,db: SQLiteDatabase?): UserWeb?
    {
        val cursor = db?.query(UsersFoldersTable.FOLDERS_TABLE_NAME, null, null, null,
            null, null, null)

        var key: String? = null
        var id: String? = null
        var name: String? = null
        var order: String? = null
        var i: Int = 0
        var userFolderWeb: ArrayList<FolderWeb?>? = ArrayList()
        while(cursor?.moveToNext() == true)
        {
            key = cursor.getString(cursor.getColumnIndex(UsersFoldersTable.FOLDERS_COLUMN_NAME_KEY))
            id = cursor.getString(cursor.getColumnIndex(UsersFoldersTable.FOLDERS_COLUMN_NAME_ID))
            name = cursor.getString(cursor.getColumnIndex(UsersFoldersTable.FOLDERS_COLUMN_NAME_NAME))
            order = cursor.getString(cursor.getColumnIndex(UsersFoldersTable.FOLDERS_COLUMN_NAME_ORDER))
            Log.d("LocalDb", "${UsersFoldersTable.FOLDERS_TABLE_NAME} KEY : $key")
            Log.d("LocalDb", "${UsersFoldersTable.FOLDERS_TABLE_NAME} ID : $id")
            Log.d("LocalDb", "${UsersFoldersTable.FOLDERS_TABLE_NAME} NAME : $name")
            Log.d("LocalDb", "${UsersFoldersTable.FOLDERS_TABLE_NAME} ORDER : $order")
            Log.d("LocalDb", "READ ITERATION: $i \n=")
            if(userWeb?.id == key)
            {
                userFolderWeb?.add(FolderWeb(id = id, name = name, order = order))
            }
            i+=1
        }
        cursor?.close()
        userWeb?.folderWeb = userFolderWeb

        return userWeb
    }
}