package com.example.ngs_test_login.MainActivity.Domain.User

interface UserLocalDbProviderInterface
{
    fun saveName()

    fun getName()

    fun saveId()

    fun getId()

    fun saveEmail()

    fun getEmail()

    fun saveLanguage()

    fun getLanguage()

    fun saveShowSidebar()

    fun getShowSidebar()

    fun saveDiskSpace()

    fun getDiskSpace()

    fun saveExpandSubtask()

    fun getExpandSubtask()

    fun saveNewTask()

    fun getNewTask()

    fun saveShortcutInbox()

    fun getShortcutInbox()
}