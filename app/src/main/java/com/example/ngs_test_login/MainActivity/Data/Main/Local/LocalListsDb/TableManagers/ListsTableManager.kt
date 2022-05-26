package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsTable
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList

class ListsTableManager
{
    fun write(list: DataList?,db: SQLiteDatabase?)
    {
        val values: ContentValues = ContentValues().apply {
            put(ListsTable.LISTS_COLUMN_NAME_NAME, list?.name)
            put(ListsTable.LISTS_COLUMN_NAME_ID, list?.id)
            put(ListsTable.LISTS_COLUMN_NAME_AUTHOR, list?.author)
            put(ListsTable.LISTS_COLUMN_NAME_DATE, list?.date)
            put(ListsTable.LISTS_COLUMN_NAME_ORDER, list?.orderBy)
        }
        db?.insert(ListsTable.LISTS_TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun read(db: SQLiteDatabase?)
    {
        val cursor: Cursor? = db?.query(ListsTable.LISTS_TABLE_NAME,null,null,
            null,null,null,null)
        var name: String? = null
        var id: String? = null
        var author: String? = null
        var date: String? = null
        var order: String? = null
        while (cursor?.moveToNext() == true)
        {
            name = cursor.getString(cursor.getColumnIndex(ListsTable.LISTS_COLUMN_NAME_NAME))
            id = cursor.getString(cursor.getColumnIndex(ListsTable.LISTS_COLUMN_NAME_ID))
            author = cursor.getString(cursor.getColumnIndex(ListsTable.LISTS_COLUMN_NAME_AUTHOR))
            date = cursor.getString(cursor.getColumnIndex(ListsTable.LISTS_COLUMN_NAME_DATE))
            order = cursor.getString(cursor.getColumnIndex(ListsTable.LISTS_COLUMN_NAME_ORDER))
            Log.d("LocalDb","${ListsTable.LISTS_TABLE_NAME} NAME : $name")
            Log.d("LocalDb","${ListsTable.LISTS_TABLE_NAME} ID : $id")
            Log.d("LocalDb","${ListsTable.LISTS_TABLE_NAME} AUTHOR : $author")
            Log.d("LocalDb","${ListsTable.LISTS_TABLE_NAME} DATE : $date")
            Log.d("LocalDb","${ListsTable.LISTS_TABLE_NAME} ORDER : $order")
        }
        cursor?.close()
    }
}