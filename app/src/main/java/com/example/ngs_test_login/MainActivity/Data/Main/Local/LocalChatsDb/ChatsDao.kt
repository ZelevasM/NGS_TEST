package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.Entities.ChatsEntity

@Dao
interface ChatsDao
{
    @Insert(onConflict = REPLACE)
    fun insertAllChats(chats: ArrayList<ChatsEntity?>?)

    @Query("SELECT * FROM chats_table")
    fun getAllChats(): ArrayList<ChatsEntity?>?

    @Insert(onConflict = REPLACE)
    fun insertChat(chat: ChatsEntity?)

    @Update
    fun updateChat(chat: ChatsEntity?)

    @Delete
    fun deleteChat(chat: ChatsEntity?)

    @Query("SELECT * FROM chats_table WHERE id = :chatId")
    fun getChat(chatId: String?): ChatsEntity?
}
