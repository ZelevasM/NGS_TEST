package com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.Tables.FoldersTable
import com.example.ngs_test_login.MainActivity.Domain.Models.Folder
import com.example.ngs_test_login.MainActivity.Domain.Models.User

class FoldersTableManager
{
    fun write(user: User?, db: SQLiteDatabase?)
    {
        val folderValues: ContentValues = ContentValues()
        if(user?.folder != null)
        {
            Log.d("LocalDb", "SIZE: ${user.folder?.size}")
            for(i in user.folder?.indices!!)
            {
                folderValues.put(FoldersTable.FOLDERS_COLUMN_NAME_KEY,user.id)
                folderValues.put(FoldersTable.FOLDERS_COLUMN_NAME_ID, user.folder?.get(i)?.id)
                folderValues.put(FoldersTable.FOLDERS_COLUMN_NAME_NAME, user.folder?.get(i)?.name)
                folderValues.put(FoldersTable.FOLDERS_COLUMN_NAME_ORDER, user.folder?.get(i)?.order)
                db?.insert(FoldersTable.FOLDERS_TABLE_NAME, null, folderValues)
            }
        }
    }

    @SuppressLint("Range")
    fun read(user: User?,db: SQLiteDatabase?): User?
    {
        val cursor = db?.query(FoldersTable.FOLDERS_TABLE_NAME, null, null, null,
            null, null, null)

        var key: String? = null
        var id: String? = null
        var name: String? = null
        var order: String? = null
        var i: Int = 0
        var userFolder: ArrayList<Folder?>? = ArrayList()
        while(cursor?.moveToNext() == true)
        {
            key = cursor.getString(cursor.getColumnIndex(FoldersTable.FOLDERS_COLUMN_NAME_KEY))
            id = cursor.getString(cursor.getColumnIndex(FoldersTable.FOLDERS_COLUMN_NAME_ID))
            name = cursor.getString(cursor.getColumnIndex(FoldersTable.FOLDERS_COLUMN_NAME_NAME))
            order = cursor.getString(cursor.getColumnIndex(FoldersTable.FOLDERS_COLUMN_NAME_ORDER))
            Log.d("LocalDb", "${FoldersTable.FOLDERS_TABLE_NAME} KEY : $key")
            Log.d("LocalDb", "${FoldersTable.FOLDERS_TABLE_NAME} ID : $id")
            Log.d("LocalDb", "${FoldersTable.FOLDERS_TABLE_NAME} NAME : $name")
            Log.d("LocalDb", "${FoldersTable.FOLDERS_TABLE_NAME} ORDER : $order")
            Log.d("LocalDb", "READ ITERATION: $i \n=")
            if(user?.id == key)
            {
                userFolder?.add(Folder(id = id, name = name, order = order))
            }
            i+=1
        }
        cursor?.close()
        user?.folder = userFolder

        return user
    }
}