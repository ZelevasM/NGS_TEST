package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Converters.ListsSectionsConverters
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Converters.ListsTasksConverters
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Converters.ListsUsersConverters
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Entities.ListsEntity

@Database(entities = [ListsEntity::class], version = 1, exportSchema = false)
@TypeConverters(ListsUsersConverters::class, ListsSectionsConverters::class, ListsTasksConverters::class)
abstract class ListsDatabase: RoomDatabase()
{
    abstract fun listsDao(): ListsDao

    companion object
    {
        @Volatile
        private var INSTANCE: ListsDatabase? = null

        fun getDatabase(context: Context): ListsDatabase
        {
            val tempInstance = INSTANCE
            if(tempInstance != null)
                return tempInstance

            synchronized(this)
            {
                val instance = Room.databaseBuilder(context.applicationContext, ListsDatabase::class.java, "lists_database").build()
                INSTANCE = instance
                return instance
            }
        }

        fun closeDatabase()
        {
            if(INSTANCE?.isOpen == true)
            {
                INSTANCE?.close()
            }
        }
    }
}