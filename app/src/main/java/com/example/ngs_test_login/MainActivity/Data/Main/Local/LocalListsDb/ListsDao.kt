package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Entities.ListsEntity
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task

@Dao
interface ListsDao
{
    @Insert(onConflict = REPLACE)
    fun insertAllLists(dataLists: ArrayList<ListsEntity?>?)

    @Query("SELECT * FROM lists_table")
    fun getAllLists(): List<ListsEntity?>?

    @Insert(onConflict = REPLACE)
    fun insertList(dataList: ListsEntity?)

    @Update
    fun updateList(dataList: ListsEntity?)

    @Delete
    fun deleteList(dataList: ListsEntity?)

    @Query("SELECT * FROM lists_table WHERE id = :listId")
    fun getList(listId: String?): ListsEntity?

    //Tasks' Methods

//    @Query("SELECT tasks FROM lists_table WHERE id = :listId")
//    fun getTasksOfList(listId: String?): List<Task?>?

    //Insert + Done + Note + Order + Rename + Delete: All through 'Update Query'
    @Query("UPDATE lists_table SET tasks =:tasks WHERE id =:listId")
    fun updateTask(tasks: ArrayList<Task?>?, listId: String?)


}