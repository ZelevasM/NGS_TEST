package com.example.ngs_test_login.MainActivity.Domain.User

import android.database.sqlite.SQLiteDatabase
import com.example.ngs_test_login.MainActivity.Data.User.Models.UserWeb

interface UserLocalProviderInterface
{
    //USER SETTINGS
    fun saveName(vararg userWeb: UserWeb?,db: SQLiteDatabase?,name: String?)

    fun getName(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?

    fun saveEmail(vararg userWeb: UserWeb?,db: SQLiteDatabase?,email: String?)

    fun getEmail(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?

    //fun save/get Password

    //USER GENERAL SETTINGS
    fun saveLanguage(vararg userWeb: UserWeb?,db: SQLiteDatabase?,language: String?)

    fun getLanguage(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?

    fun saveHomepage(vararg userWeb: UserWeb?,db: SQLiteDatabase?,homepage: String?)

    fun getHomepage(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?

    fun saveExpandSubtask(vararg userWeb: UserWeb?,db: SQLiteDatabase?,expandSubtask: String?)

    fun getExpandSubtask(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?

    fun saveNewTask(vararg userWeb: UserWeb?,db: SQLiteDatabase?,newTask: String?)

    fun getNewTask(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
    //IRRELEVANT

    fun saveDiskSpace(vararg userWeb: UserWeb?,db: SQLiteDatabase?,diskSpace: String?)

    fun getDiskSpace(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?

    fun saveShortcutInbox(vararg userWeb: UserWeb?,db: SQLiteDatabase?)

    fun getShortcutInbox(vararg userWeb: UserWeb?)

    fun saveShowSidebar(vararg userWeb: UserWeb?,db: SQLiteDatabase?,sidebar: String?)

    fun getShowSidebar(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?

    fun saveId(vararg userWeb: UserWeb?,db: SQLiteDatabase?)

    fun getId(vararg userWeb: UserWeb?,db: SQLiteDatabase?): String?
}