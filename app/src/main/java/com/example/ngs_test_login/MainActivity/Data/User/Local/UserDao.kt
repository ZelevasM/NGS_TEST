package com.example.ngs_test_login.MainActivity.Data.User.Local

import androidx.room.*
import com.example.ngs_test_login.LoginActivity.Domain.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.Models.DateFormat
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Homepage

@Dao
interface UserDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User?)

    @Query("SELECT * FROM user_table")
    fun getUser(): List<User?>?

    @Update
    fun updateUser(user: User?)

    @Delete
    fun deleteUser(user: User?)

    //-User Info Repository

    @Query("UPDATE user_table SET name = :name")
    fun updateName(name: String?)

    @Query("SELECT name FROM user_table")
    fun getName(chatId: String?): String?

    @Query("UPDATE user_table SET email = :email")
    fun updateEmail(email: String?)

    @Query("SELECT email FROM user_table")
    fun getEmail()

    //-General Settings Repository

    @Query("UPDATE user_table SET language = :language")
    fun updateLanguage(language: String?)

    @Query("SELECT language FROM user_table")
    fun getLanguage()

    @Query("UPDATE user_table SET homepage = :homepage")
    fun updateHomepage(homepage: Homepage?)

    @Query("SELECT homepage FROM user_table")
    fun getHomepage()

    @Query("UPDATE user_table SET expandSubtask = :expandSubtask")
    fun updateExpandSubtask(expandSubtask: Boolean?)

    @Query("SELECT expandSubtask FROM user_table")
    fun getExpandSubtask()

    @Query("UPDATE user_table SET newTask = :newTask")
    fun updateNewTask(newTask: Boolean?)

    @Query("SELECT newTask FROM user_table")
    fun getNewTask()

    //-Date Format Repository

    @Query("UPDATE user_table SET dateFormatWeb = :dateFormat")
    fun updateDateFormat(dateFormat: DateFormat?)

    @Query("SELECT name FROM user_table")
    fun getDateFormat()

    @Query("UPDATE user_table SET dateFormatWeb = :timeFormat")
    fun updateTimeFormat(timeFormat: DateFormat?)

    @Query("")
    fun getTimeFormat()

    @Query("UPDATE user_table SET dateFormatWeb = :startOfWeek")
    fun updateStartOfWeek(startOfWeek: DateFormat?)

    @Query("")
    fun getStartOfWeek()

    //-Shortcuts' Repository

    @Query("")
    fun updateShortcuts()

    @Query("")
    fun getShortcuts()

}