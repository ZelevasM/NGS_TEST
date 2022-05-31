package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.TableManagers.ListsTasksTableManager
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.TableManagers.ListsTableManager
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.TableManagers.ListsTasksMessagesTableManager
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.TableManagers.ListsUsersTableManager
import com.example.ngs_test_login.MainActivity.Data.User.Local.LocalUserDb.TableManagers.*
import com.example.ngs_test_login.MainActivity.Domain.Main.ListsLocalDbProviderInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList

class ListsDatabaseManager(private val context: Context): ListsLocalDbProviderInterface
{
    private val listsDatabaseHelper: ListsDatabaseHelper = ListsDatabaseHelper(context)
    private var mDb: SQLiteDatabase? = null

    //TableManagers
    private var listsTableManager: ListsTableManager = ListsTableManager()
    private var listsUsersTableManager: ListsUsersTableManager = ListsUsersTableManager()
    private var listsTasksTableManager: ListsTasksTableManager = ListsTasksTableManager()
    private var listsTasksMessagesTableManager: ListsTasksMessagesTableManager = ListsTasksMessagesTableManager()

    fun openDb(): Boolean
    {
        //TODO SUPER MEGA GOVNO CODE -> CHANGE IT
        var newlyCreated: Boolean = true
        mDb = listsDatabaseHelper.writableDatabase

        if (mDb != null)
        {
            newlyCreated = false
        }
        Log.d("LocalDb","DB NEW: $newlyCreated")
        return newlyCreated
    }

    fun writeToDb(dataLists: ArrayList<DataList?>?)
    {
        listsDatabaseHelper.onUpgrade(mDb,ListsDatabase.DATABASE_VERSION,ListsDatabase.DATABASE_VERSION)
        listsTableManager.write(dataLists,mDb)
        listsUsersTableManager.write(dataLists,mDb)
        listsTasksTableManager.write(dataLists, mDb)
        listsTasksMessagesTableManager.write(dataLists, mDb)
    }

    @SuppressLint("Range")
    fun readFromDb(): ArrayList<DataList?>?
    {
        var dataLists: ArrayList<DataList?>? = listsTableManager.read(mDb)
        dataLists = listsUsersTableManager.read(dataLists, mDb)
        dataLists = listsTasksTableManager.read(dataLists, mDb)
        dataLists = listsTasksMessagesTableManager.read(dataLists, mDb)
        return dataLists
    }

    fun closeDb()
    {
        //close db helper
        listsDatabaseHelper.close()
    }

    override fun addLocalList(dataList: DataList,dataLists: ArrayList<DataList?>?)
    {
        listsTableManager
        listsTasksTableManager
        listsTasksMessagesTableManager
        listsUsersTableManager
    }

    override fun updateLocalList(dataList: DataList,dataLists: ArrayList<DataList?>?)
    {}

    override fun deleteLocalList(dataList: DataList,dataLists: ArrayList<DataList?>?)
    {}

    override fun getLocalList(dataList: DataList,dataLists: ArrayList<DataList?>?)
    {}
}