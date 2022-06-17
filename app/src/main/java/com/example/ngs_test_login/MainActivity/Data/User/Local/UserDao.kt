package com.example.ngs_test_login.MainActivity.Data.User.Local

import androidx.room.*
import com.example.ngs_test_login.MainActivity.Data.User.Local.Entities.UserEntity
import com.example.ngs_test_login.MainActivity.Domain.User.Models.DateFormat
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Homepage
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.User.Models.User

@Dao
interface UserDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity?)

    @Query("SELECT * FROM user_table")
    fun getUser(): List<UserEntity?>?

    @Update
    fun updateUser(user: UserEntity?)

    @Delete
    fun deleteUser(user: UserEntity?)

    //-User Info Repository

    @Query("UPDATE user_table SET name = :name")
    fun updateName(name: String?)

    @Query("SELECT name FROM user_table")
    fun getName(): String?

    @Query("UPDATE user_table SET email = :email")
    fun updateEmail(email: String?)

    @Query("SELECT email FROM user_table")
    fun getEmail(): String?

    //-General Settings Repository

    @Query("UPDATE user_table SET language = :language")
    fun updateLanguage(language: String?)

    @Query("SELECT language FROM user_table")
    fun getLanguage(): String?

    @Query("UPDATE user_table SET type = :homepage")
    fun updateHomepage(homepage: String?)

    @Query("SELECT type FROM user_table")
    fun getHomepage(): String?

    @Query("UPDATE user_table SET expandSubtask = :expandSubtask")
    fun updateExpandSubtask(expandSubtask: Boolean?)

    @Query("SELECT expandSubtask FROM user_table")
    fun getExpandSubtask(): Boolean?

    @Query("UPDATE user_table SET newTask = :newTask")
    fun updateNewTask(newTask: Boolean?)

    @Query("SELECT newTask FROM user_table")
    fun getNewTask(): Boolean?

    //-Date Format Repository

    @Query("UPDATE user_table SET date = :dateFormat")
    fun updateDateFormat(dateFormat: String?)

    @Query("SELECT date FROM user_table")
    fun getDateFormat(): String?

    @Query("UPDATE user_table SET time = :timeFormat")
    fun updateTimeFormat(timeFormat: String?)

    @Query("SELECT time FROM user_table")
    fun getTimeFormat(): String?

    @Query("UPDATE user_table SET startOfTheWeek = :startOfWeek")
    fun updateStartOfWeek(startOfWeek: String?)

    @Query("SELECT startOfTheWeek FROM user_table")
    fun getStartOfWeek(): String?

    //-Shortcuts' Repository

//    @Query("UPDATE user_table SET shortcuts = :shortcuts")
//    fun updateShortcuts(shortcuts: ArrayList<Shortcut?>?)
//
//    @Query("SELECT shortcuts FROM user_table")
//    fun getShortcuts(): List<Shortcut?>?

}