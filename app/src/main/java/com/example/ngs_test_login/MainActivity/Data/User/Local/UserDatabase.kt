package com.example.ngs_test_login.MainActivity.Data.User.Local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ngs_test_login.MainActivity.Data.User.Local.Converters.UserFoldersConverters
import com.example.ngs_test_login.MainActivity.Data.User.Local.Converters.UserShortcutsConverters
import com.example.ngs_test_login.MainActivity.Data.User.Local.Entities.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
@TypeConverters(UserShortcutsConverters::class, UserFoldersConverters::class)
abstract class UserDatabase: RoomDatabase()
{
    abstract fun userDao(): UserDao

    companion object
    {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase
        {
            val tempInstance = INSTANCE
            if(tempInstance != null)
                return tempInstance

            synchronized(this)
            {
                val instance = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "user_database").build()
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