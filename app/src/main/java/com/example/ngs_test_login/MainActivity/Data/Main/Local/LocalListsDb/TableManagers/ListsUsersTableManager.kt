package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsTable
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsUsersTable
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList
import com.example.ngs_test_login.MainActivity.Domain.Models.ListUser

class ListsUsersTableManager
{
    fun write(lists: ArrayList<DataList?>?,db: SQLiteDatabase?)
    {
        for(i in lists?.indices!!)
        {
            for(j in lists[i]?.users?.indices!!)
            {
                val values: ContentValues = ContentValues().apply {
                    put(ListsUsersTable.COLUMN_NAME_KEY,lists[i]?.id)
                    put(ListsUsersTable.COLUMN_NAME_ID,lists[i]?.users?.get(j)?.id)
                    put(ListsUsersTable.COLUMN_NAME_ORDER,lists[i]?.users?.get(j)?.order)
                    put(ListsUsersTable.COLUMN_NAME_NOTE_SIZE,lists[i]?.users?.get(j)?.noteSize)
                    put(ListsUsersTable.COLUMN_NAME_LAST_SEEN,lists[i]?.users?.get(j)?.lastSeen)
                    put(ListsUsersTable.COLUMN_NAME_UNREAD_MESSAGE,lists[i]?.users?.get(j)?.unreadMessage)
                    put(ListsUsersTable.COLUMN_NAME_MUTED,lists[i]?.users?.get(j)?.muted)
                }
                db?.insert(ListsUsersTable.TABLE_NAME,null,values)
            }
        }
    }

    @SuppressLint("Range")
    fun read(dataLists: ArrayList<DataList?>?, db: SQLiteDatabase?): ArrayList<DataList?>?
    {
        val cursor: Cursor? = db?.query(ListsUsersTable.TABLE_NAME,null,null,
            null,null,null,null)
        var key: String? = null
        var id: String? = null
        var order: String? = null
        var noteSize: String? = null
        var lastSeen: String? = null
        //int
        var unreadMessage: Int? = null
        //boolean
        var muted: String? = null
        val users: ArrayList<ListUser?>? = ArrayList()
        var user: ListUser?

        for(i in dataLists?.indices!!)
        {
            while (cursor?.moveToNext() == true)
            {
                key = cursor.getString(cursor.getColumnIndex(ListsUsersTable.COLUMN_NAME_KEY))
                id = cursor.getString(cursor.getColumnIndex(ListsUsersTable.COLUMN_NAME_ID))
                order = cursor.getString(cursor.getColumnIndex(ListsUsersTable.COLUMN_NAME_ORDER))
                noteSize = cursor.getString(cursor.getColumnIndex(ListsUsersTable.COLUMN_NAME_NOTE_SIZE))
                lastSeen = cursor.getString(cursor.getColumnIndex(ListsUsersTable.COLUMN_NAME_LAST_SEEN))
                unreadMessage = cursor.getInt(cursor.getColumnIndex(ListsUsersTable.COLUMN_NAME_UNREAD_MESSAGE))
                muted = cursor.getString(cursor.getColumnIndex(ListsUsersTable.COLUMN_NAME_MUTED))
                Log.d("LocalDb","${ListsUsersTable.TABLE_NAME} NAME : $key")
                Log.d("LocalDb","${ListsUsersTable.TABLE_NAME} ID : $id")
                if(dataLists[i]?.id == key)
                {
                    user = ListUser(id = id, order = order, noteSize = noteSize, lastSeen = lastSeen,
                        unreadMessage = unreadMessage, muted = muted.toBoolean())
                    users?.add(user)
                    dataLists[i]?.users = users
                }
            }
        }
        cursor?.close()
        return dataLists
    }
}