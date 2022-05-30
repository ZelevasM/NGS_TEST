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
    fun write(lists: ArrayList<DataList?>?,db: SQLiteDatabase?)
    {
        for(i in lists?.indices!!)
        {
            val values: ContentValues = ContentValues().apply {
                put(ListsTable.LISTS_COLUMN_NAME_NAME,lists[i]?.name)
                put(ListsTable.LISTS_COLUMN_NAME_ID,lists[i]?.id)
                put(ListsTable.LISTS_COLUMN_NAME_AUTHOR,lists[i]?.author)
                put(ListsTable.LISTS_COLUMN_NAME_DATE,lists[i]?.date)
                put(ListsTable.LISTS_COLUMN_NAME_ORDER,lists[i]?.order)
                put(ListsTable.LISTS_COLUMN_NAME_COLOR,lists[i]?.color)
            }
            db?.insert(ListsTable.LISTS_TABLE_NAME,null,values)
        }
    }

    @SuppressLint("Range")
    fun read(db: SQLiteDatabase?): ArrayList<DataList?>
    {
        val cursor: Cursor? = db?.query(ListsTable.LISTS_TABLE_NAME,null,null,
            null,null,null,null)
        var name: String? = null
        var id: String? = null
        var author: String? = null
        var date: String? = null
        var order: Int? = null
        var color: String? = null
        val lists: ArrayList<DataList?> = ArrayList()
        var dataList: DataList? = null
        while (cursor?.moveToNext() == true)
        {
            name = cursor.getString(cursor.getColumnIndex(ListsTable.LISTS_COLUMN_NAME_NAME))
            id = cursor.getString(cursor.getColumnIndex(ListsTable.LISTS_COLUMN_NAME_ID))
            author = cursor.getString(cursor.getColumnIndex(ListsTable.LISTS_COLUMN_NAME_AUTHOR))
            date = cursor.getString(cursor.getColumnIndex(ListsTable.LISTS_COLUMN_NAME_DATE))
            order = cursor.getInt(cursor.getColumnIndex(ListsTable.LISTS_COLUMN_NAME_ORDER))
            color = cursor.getString(cursor.getColumnIndex(ListsTable.LISTS_COLUMN_NAME_COLOR))
            Log.d("LocalDb","${ListsTable.LISTS_TABLE_NAME} NAME : $name")
            Log.d("LocalDb","${ListsTable.LISTS_TABLE_NAME} ID : $id")
            Log.d("LocalDb","${ListsTable.LISTS_TABLE_NAME} AUTHOR : $author")
            Log.d("LocalDb","${ListsTable.LISTS_TABLE_NAME} DATE : $date")
            Log.d("LocalDb","${ListsTable.LISTS_TABLE_NAME} ORDER : $order")
            dataList = DataList(name = name, id = id, author = author, date = date, order = order, color = color)
            lists.add(dataList)
        }
        cursor?.close()
        return lists
    }
}