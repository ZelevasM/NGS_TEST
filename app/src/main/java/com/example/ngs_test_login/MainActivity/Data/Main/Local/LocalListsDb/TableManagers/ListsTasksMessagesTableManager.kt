package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsTable
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsTasksMessagesTable
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Tables.ListsTasksTable
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList
import com.example.ngs_test_login.MainActivity.Domain.Models.Task
import com.example.ngs_test_login.MainActivity.Domain.Models.TaskMessage
import kotlin.text.Typography.section

class ListsTasksMessagesTableManager
{
    fun write(lists: ArrayList<DataList?>?,db: SQLiteDatabase?)
    {
        for(i in lists?.indices!!)
        {
            for(j in lists[i]?.tasks?.indices!!)
            {
                for(k in lists[i]?.tasks?.get(j)?.messages?.indices!!)
                {
                    val values: ContentValues = ContentValues().apply {
                        put(ListsTasksMessagesTable.COLUMN_NAME_KEY,lists[i]?.tasks?.get(j)?.id)
                        put(ListsTasksMessagesTable.COLUMN_NAME_ID,lists[i]?.tasks?.get(j)?.messages?.get(k)?.id)
                        put(ListsTasksMessagesTable.COLUMN_NAME_USER_ID,lists[i]?.tasks?.get(j)?.messages?.get(k)?.userId)
                        put(ListsTasksMessagesTable.COLUMN_NAME_MESSAGE,lists[i]?.tasks?.get(j)?.messages?.get(k)?.message)
                        put(ListsTasksMessagesTable.COLUMN_NAME_DATE,lists[i]?.tasks?.get(j)?.messages?.get(k)?.date)
                        put(ListsTasksMessagesTable.COLUMN_NAME_REMOVE_FILE,lists[i]?.tasks?.get(j)?.messages?.get(k)?.removeFile)
                        put(ListsTasksMessagesTable.COLUMN_NAME_READ,lists[i]?.tasks?.get(j)?.messages?.get(k)?.read)
                    }
                    db?.insert(ListsTasksMessagesTable.TABLE_NAME,null,values)
                }
            }
        }
    }

    @SuppressLint("Range")
    fun read(dataLists: ArrayList<DataList?>?,db: SQLiteDatabase?): ArrayList<DataList?>?
    {
        val cursor: Cursor? = db?.query(ListsTasksMessagesTable.TABLE_NAME,null,null,
            null,null,null,null)
        var key: String? = null
        var id: String? = null
        var userId: String? = null
        var message: String? = null
        var date: String? = null
        //boolean
        var removeFile: String? = null
        var read: String? = null

        val taskMessages: ArrayList<TaskMessage?>? = ArrayList()
        var taskMessage: TaskMessage?

        if(dataLists?.indices != null)
        {
            for (i in dataLists.indices)
            {
                if(dataLists[i]?.tasks?.indices != null)
                {
                    for (j in dataLists[i]?.tasks?.indices!!)
                    {
                        while (cursor?.moveToNext() == true)
                        {
                            key = cursor.getString(cursor.getColumnIndex(ListsTasksMessagesTable.COLUMN_NAME_KEY))
                            id = cursor.getString(cursor.getColumnIndex(ListsTasksMessagesTable.COLUMN_NAME_ID))
                            userId = cursor.getString(cursor.getColumnIndex(ListsTasksMessagesTable.COLUMN_NAME_USER_ID))
                            message = cursor.getString(cursor.getColumnIndex(ListsTasksMessagesTable.COLUMN_NAME_MESSAGE))
                            date = cursor.getString(cursor.getColumnIndex(ListsTasksMessagesTable.COLUMN_NAME_DATE))
                            removeFile = cursor.getString(cursor.getColumnIndex(
                                ListsTasksMessagesTable.COLUMN_NAME_REMOVE_FILE))
                            read = cursor.getString(cursor.getColumnIndex(ListsTasksMessagesTable.COLUMN_NAME_READ))

                            Log.d("LocalDb","${ListsTasksMessagesTable.TABLE_NAME} NAME : $key")
                            Log.d("LocalDb","${ListsTasksMessagesTable.TABLE_NAME} ID : $id")
                            if (dataLists[i]?.tasks?.get(j)?.id == key)
                            {
                                taskMessage = TaskMessage(id = id,
                                    userId = userId,
                                    message = message,
                                    date = date,
                                    removeFile = removeFile.toBoolean(),
                                    read = read.toBoolean())
                                taskMessages?.add(taskMessage)
                                dataLists[i]?.tasks?.get(j)?.messages = taskMessages
                            }
                        }
                    }
                }
            }
        }
        cursor?.close()
        return dataLists
    }
}