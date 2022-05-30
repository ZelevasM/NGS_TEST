package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.TableManagers.ChatsMessagesTableManager
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.TableManagers.ChatsTableManager
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.ListsDatabase
import com.example.ngs_test_login.MainActivity.Domain.Models.Chat
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList

class ChatsDatabaseManager(private val context: Context)
{
    private val chatsDatabaseHelper: ChatsDatabaseHelper = ChatsDatabaseHelper(context)
    private var mDb: SQLiteDatabase? = null

    //TableManagers
    private var chatsTableManager: ChatsTableManager = ChatsTableManager()
    private var chatsMessagesTableManager: ChatsMessagesTableManager = ChatsMessagesTableManager()

    fun openDb(): Boolean
    {
        //TODO SUPER MEGA GOVNO CODE -> CHANGE IT
        var newlyCreated: Boolean = true
        mDb = chatsDatabaseHelper.writableDatabase

        if (mDb != null)
        {
            newlyCreated = false
        }
        Log.d("LocalDb","DB NEW: $newlyCreated")
        return newlyCreated
    }

    fun writeToDb(chats: ArrayList<Chat?>?)
    {
        chatsDatabaseHelper.onUpgrade(mDb,ListsDatabase.DATABASE_VERSION,ListsDatabase.DATABASE_VERSION)
        chatsTableManager.write(chats,mDb)
        chatsMessagesTableManager.write(chats, mDb)
    }

    @SuppressLint("Range")
    fun readFromDb(): ArrayList<Chat?>?
    {
        var chats: ArrayList<Chat?>? = chatsTableManager.read(mDb)
        chats = chatsMessagesTableManager.read(chats, mDb)
        Log.d("MyLog","CHAAAAATS: $chats")
        return chats
    }

    fun closeDb()
    {
        //close db helper
        chatsDatabaseHelper.close()
    }
}