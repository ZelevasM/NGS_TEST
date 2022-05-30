package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsTable
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsTasksTable
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsUsersTable
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList
import com.example.ngs_test_login.MainActivity.Domain.Models.ListUser
import com.example.ngs_test_login.MainActivity.Domain.Models.Task

class ListsTasksTableManager
{
    fun write(lists: ArrayList<DataList?>?,db: SQLiteDatabase?)
    {
        for(i in lists?.indices!!)
        {
            for(j in lists[i]?.tasks?.indices!!)
            {
                val values: ContentValues = ContentValues().apply {
                    put(ListsTasksTable.COLUMN_NAME_KEY,lists[i]?.id)
                    put(ListsTasksTable.COLUMN_NAME_ID,lists[i]?.tasks?.get(j)?.id)
                    put(ListsTasksTable.COLUMN_NAME_NOTES,lists[i]?.tasks?.get(j)?.notes)
                    put(ListsTasksTable.COLUMN_NAME_NAME,lists[i]?.tasks?.get(j)?.name)
                    put(ListsTasksTable.COLUMN_NAME_AUTHOR,lists[i]?.tasks?.get(j)?.auth)
                    put(ListsTasksTable.COLUMN_NAME_PARENT,lists[i]?.tasks?.get(j)?.parent)
                    put(ListsTasksTable.COLUMN_NAME_DATE,lists[i]?.tasks?.get(j)?.date)
                    put(ListsTasksTable.COLUMN_NAME_SECTION,lists[i]?.tasks?.get(j)?.section)
                    put(ListsTasksTable.COLUMN_NAME_PRIORITY,lists[i]?.tasks?.get(j)?.priority)
                    put(ListsTasksTable.COLUMN_NAME_ORDER,lists[i]?.tasks?.get(j)?.order)
                    put(ListsTasksTable.COLUMN_NAME_DONE,lists[i]?.tasks?.get(j)?.done)
                }
                db?.insert(ListsTasksTable.TABLE_NAME,null,values)
            }
        }
    }

    @SuppressLint("Range")
    fun read(dataLists: ArrayList<DataList?>?,db: SQLiteDatabase?): ArrayList<DataList?>?
    {
        val cursor: Cursor? = db?.query(ListsTasksTable.TABLE_NAME,null,null,
            null,null,null,null)
        var key: String? = null
        var id: String? = null
        var notes: String? = null
        var name: String? = null
        var author: String? = null
        var parent: String? = null
        var date: String? = null
        var section: String? = null
        var priority: String? = null
        //int
        var order: Int? = null
        //boolean
        var done: String? = null
        val tasks: ArrayList<Task?>? = ArrayList()
        var task: Task?

        while (cursor?.moveToNext() == true)
        {
            key = cursor.getString(cursor.getColumnIndex(ListsTasksTable.COLUMN_NAME_KEY))
            id = cursor.getString(cursor.getColumnIndex(ListsTasksTable.COLUMN_NAME_ID))
            notes = cursor.getString(cursor.getColumnIndex(ListsTasksTable.COLUMN_NAME_NOTES))
            name = cursor.getString(cursor.getColumnIndex(ListsTasksTable.COLUMN_NAME_NAME))
            author = cursor.getString(cursor.getColumnIndex(ListsTasksTable.COLUMN_NAME_AUTHOR))
            parent = cursor.getString(cursor.getColumnIndex(ListsTasksTable.COLUMN_NAME_PARENT))
            date = cursor.getString(cursor.getColumnIndex(ListsTasksTable.COLUMN_NAME_DATE))
            section = cursor.getString(cursor.getColumnIndex(ListsTasksTable.COLUMN_NAME_SECTION))
            priority = cursor.getString(cursor.getColumnIndex(ListsTasksTable.COLUMN_NAME_PRIORITY))
            order = cursor.getInt(cursor.getColumnIndex(ListsTasksTable.COLUMN_NAME_ORDER))
            done = cursor.getString(cursor.getColumnIndex(ListsTasksTable.COLUMN_NAME_DONE))
            for(i in dataLists?.indices!!)
            {
                if(dataLists[i]?.id == key)
                {
                   task = Task(id=id, notes = notes, name = name, auth = author,
                        parent = parent, date = date, section = section, priority = priority,
                        order = order, done = done.toBoolean())
                    tasks?.add(task)
                    dataLists[i]?.tasks = tasks
                }
             }
        }
        cursor?.close()
        return dataLists
    }
}
//                    Log.d("LocalDb","${ListsTasksTable.TABLE_NAME} KEY : $key")
//                    Log.d("LocalDb","${ListsTasksTable.TABLE_NAME} ID : $id")
//                    Log.d("LocalDb","${ListsTasksTable.TABLE_NAME} PRIORITY : $priority")
//                    Log.d("LocalDb","${ListsTasksTable.TABLE_NAME} PARENT : $parent")
//                    Log.d("LocalDb","${ListsTasksTable.TABLE_NAME} ORDER : $order")
//                    Log.d("LocalDb","${ListsTasksTable.TABLE_NAME} DONE : $done\n/")
//                    Log.d("LocalDb","${ListsTasksTable.TABLE_NAME} TASK KEY : $key\n")
//                    Log.d("LocalDb","${ListsTasksTable.TABLE_NAME} LIST ID : ${dataLists[i]?.id}")
//                    Log.d("LocalDb","${ListsTasksTable.TABLE_NAME} LISTS SIZE : ${dataLists.size}")
//                    Log.d("LocalDb","${ListsTasksTable.TABLE_NAME} CURR ITER : $j")