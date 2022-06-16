package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Converters.ChatsMessagesConverters
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Converters.ChatsUsersConverters
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Entities.ChatsEntity

@Database(entities = [ChatsEntity::class], version = 1, exportSchema = false)
@TypeConverters(ChatsUsersConverters::class, ChatsMessagesConverters::class)
abstract class ChatsDatabase: RoomDatabase()
{
    abstract fun chatsDao(): ChatsDao

    companion object
    {
        @Volatile
        private var INSTANCE: ChatsDatabase? = null

        fun getDatabase(context: Context): ChatsDatabase
        {
            val tempInstance = INSTANCE
            if(tempInstance != null)
                return tempInstance

            synchronized(this)
            {
                val instance = Room.databaseBuilder(context.applicationContext, ChatsDatabase::class.java, "user_database").build()
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