package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Tables.ChatsTable
import com.example.ngs_test_login.MainActivity.Domain.Models.Chat
class ChatsTableManager
{
    fun write(chats: ArrayList<Chat?>?,db: SQLiteDatabase?)
    {
        for(i in chats?.indices!!)
        {
            val values: ContentValues = ContentValues().apply {
                put(ChatsTable.COLUMN_NAME_ID,chats[i]?.id)
                put(ChatsTable.COLUMN_NAME_NAME,chats[i]?.name)
                put(ChatsTable.COLUMN_NAME_DATE,chats[i]?.date)
                put(ChatsTable.COLUMN_NAME_AUTHOR,chats[i]?.auth)
                put(ChatsTable.COLUMN_NAME_PROJECT_ID,chats[i]?.projectId)
                put(ChatsTable.COLUMN_NAME_VERSION,chats[i]?.V)
            }
            db?.insert(ChatsTable.TABLE_NAME,null,values)
        }
    }

    @SuppressLint("Range")
    fun read(db: SQLiteDatabase?): ArrayList<Chat?>
    {
        val cursor: Cursor? = db?.query(ChatsTable.TABLE_NAME,null,null,
            null,null,null,null)
        var id: String? = null
        var name: String? = null
        var date: String? = null
        var author: String? = null
        var projectId: String? = null
        var version: String? = null

        val chats: ArrayList<Chat?> = ArrayList()
        var chat: Chat? = null
        while (cursor?.moveToNext() == true)
        {
            id = cursor.getString(cursor.getColumnIndex(ChatsTable.COLUMN_NAME_ID))
            name = cursor.getString(cursor.getColumnIndex(ChatsTable.COLUMN_NAME_NAME))
            date = cursor.getString(cursor.getColumnIndex(ChatsTable.COLUMN_NAME_DATE))
            author = cursor.getString(cursor.getColumnIndex(ChatsTable.COLUMN_NAME_AUTHOR))
            projectId = cursor.getString(cursor.getColumnIndex(ChatsTable.COLUMN_NAME_PROJECT_ID))
            version = cursor.getString(cursor.getColumnIndex(ChatsTable.COLUMN_NAME_VERSION))
            Log.d("LocalDb","${ChatsTable.TABLE_NAME} NAME : $name")
            Log.d("LocalDb","${ChatsTable.TABLE_NAME} ID : $id")
            Log.d("LocalDb","${ChatsTable.TABLE_NAME} DATE : $date")
            Log.d("LocalDb","${ChatsTable.TABLE_NAME} AUTHOR : $author")
            Log.d("LocalDb","${ChatsTable.TABLE_NAME} PROJECT ID : $projectId")
            chat = Chat(name = name, id = id, date = date, auth = author, projectId = projectId)
            chats.add(chat)
        }
        cursor?.close()
        return chats
    }
}