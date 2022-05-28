package com.example.ngs_test_login.MainActivity.Domain.User

import android.database.sqlite.SQLiteDatabase
import com.example.ngs_test_login.MainActivity.Domain.Models.User

interface UserLocalProviderInterface
{
    //USER SETTINGS
    fun saveName(vararg user: User?, db: SQLiteDatabase?, name: String?)

    fun getName(vararg user: User?, db: SQLiteDatabase?): String?

    fun saveEmail(vararg user: User?, db: SQLiteDatabase?, email: String?)

    fun getEmail(vararg user: User?, db: SQLiteDatabase?): String?

    //fun save/get Password

    //USER GENERAL SETTINGS
    fun saveLanguage(vararg user: User?, db: SQLiteDatabase?, language: String?)

    fun getLanguage(vararg user: User?, db: SQLiteDatabase?): String?

    fun saveHomepage(vararg user: User?, db: SQLiteDatabase?, homepage: String?)

    fun getHomepage(vararg user: User?, db: SQLiteDatabase?): String?

    fun saveExpandSubtask(vararg user: User?, db: SQLiteDatabase?, expandSubtask: String?)

    fun getExpandSubtask(vararg user: User?, db: SQLiteDatabase?): String?

    fun saveNewTask(vararg user: User?, db: SQLiteDatabase?, newTask: String?)

    fun getNewTask(vararg user: User?, db: SQLiteDatabase?): String?

    //IRRELEVANT

    fun saveDiskSpace(vararg user: User?, db: SQLiteDatabase?, diskSpace: String?)

    fun getDiskSpace(vararg user: User?, db: SQLiteDatabase?): String?

    fun saveShortcutInbox(vararg user: User?, db: SQLiteDatabase?)

    fun getShortcutInbox(vararg user: User?)

    fun saveShowSidebar(vararg user: User?, db: SQLiteDatabase?, sidebar: String?)

    fun getShowSidebar(vararg user: User?, db: SQLiteDatabase?): String?

    fun saveId(vararg user: User?, db: SQLiteDatabase?)

    fun getId(vararg user: User?, db: SQLiteDatabase?): String?
}