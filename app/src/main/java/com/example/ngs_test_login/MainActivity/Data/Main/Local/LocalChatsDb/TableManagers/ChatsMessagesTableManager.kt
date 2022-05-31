package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.TableManagers

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Tables.ChatsMessagesTable
import com.example.ngs_test_login.MainActivity.Domain.Models.Chat
import com.example.ngs_test_login.MainActivity.Domain.Models.ChatMessage

class ChatsMessagesTableManager
{
    fun write(chats: ArrayList<Chat?>?,db: SQLiteDatabase?)
    {
        for(i in chats?.indices!!)
        {
            for(j in chats[i]?.messages?.indices!!)
            {
                val values: ContentValues = ContentValues().apply {
                    put(ChatsMessagesTable.COLUMN_NAME_KEY,chats[i]?.id)
                    put(ChatsMessagesTable.COLUMN_NAME_ID,chats[i]?.messages?.get(j)?.id)
                    put(ChatsMessagesTable.COLUMN_NAME_USER_ID,chats[i]?.messages?.get(j)?.userId)
                    put(ChatsMessagesTable.COLUMN_NAME_DATE,chats[i]?.messages?.get(j)?.date)
                    put(ChatsMessagesTable.COLUMN_NAME_REPLY,chats[i]?.messages?.get(j)?.reply)
                    put(ChatsMessagesTable.COLUMN_NAME_MESSAGE,chats[i]?.messages?.get(j)?.message)
                    put(ChatsMessagesTable.COLUMN_NAME_READ,chats[i]?.messages?.get(j)?.read)
                }
                db?.insert(ChatsMessagesTable.TABLE_NAME,null,values)
            }
        }
    }

    @SuppressLint("Range")
    fun read(chats: ArrayList<Chat?>?,db: SQLiteDatabase?): ArrayList<Chat?>?
    {
        val cursor: Cursor? = db?.query(ChatsMessagesTable.TABLE_NAME,null,null,
            null,null,null,null)
        var key: String? = null
        var id: String? = null
        var userId: String? = null
        var date: String? = null
        var reply: String? = null
        var message: String? = null
        var read: String? = null

        var chatMessage: ChatMessage? = null
        while (cursor?.moveToNext() == true)
        {
            key = cursor.getString(cursor.getColumnIndex(ChatsMessagesTable.COLUMN_NAME_KEY))
            id = cursor.getString(cursor.getColumnIndex(ChatsMessagesTable.COLUMN_NAME_ID))
            userId = cursor.getString(cursor.getColumnIndex(ChatsMessagesTable.COLUMN_NAME_USER_ID))
            date = cursor.getString(cursor.getColumnIndex(ChatsMessagesTable.COLUMN_NAME_DATE))
            reply = cursor.getString(cursor.getColumnIndex(ChatsMessagesTable.COLUMN_NAME_REPLY))
            message = cursor.getString(cursor.getColumnIndex(ChatsMessagesTable.COLUMN_NAME_MESSAGE))
            read = cursor.getString(cursor.getColumnIndex(ChatsMessagesTable.COLUMN_NAME_READ))
            Log.d("LocalDb","${ChatsMessagesTable.TABLE_NAME} KEY : $userId")
            Log.d("LocalDb","${ChatsMessagesTable.TABLE_NAME} ID : $id")
            Log.d("LocalDb","${ChatsMessagesTable.TABLE_NAME} DATE : $date")
            Log.d("LocalDb","${ChatsMessagesTable.TABLE_NAME} REPLY : $reply")
            Log.d("LocalDb","${ChatsMessagesTable.TABLE_NAME} MESSAGE : $message")
            if(chats != null)
            {
                for (i in chats.indices)
                {
                    if (chats[i]?.id == key)
                    {
                        chatMessage = ChatMessage(id = id,
                            userId = userId,
                            date = date,
                            reply = reply,
                            message = message,
                            read = read.toBoolean())
                        chats[i]?.messages?.add(chatMessage)
                    }
                }
            }
        }
        cursor?.close()
        return chats
    }
}