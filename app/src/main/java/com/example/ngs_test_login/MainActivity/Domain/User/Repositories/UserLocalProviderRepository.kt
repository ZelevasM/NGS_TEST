package com.example.ngs_test_login.MainActivity.Domain.User.Repositories

interface UserLocalProviderRepository
{
    //USER SETTINGS
    fun saveName(name: String?)

    fun getName(): String?

    fun saveEmail(email: String?)

    fun getEmail(): String?

    //fun save/get Password

    //USER GENERAL SETTINGS
    fun saveLanguage(language: String?)

    fun getLanguage(): String?

    fun saveHomepage(homepage: String?)

    fun getHomepage(): String?

    fun saveExpandSubtask(expandSubtask: String?)

    fun getExpandSubtask(): String?

    fun saveNewTask(newTask: String?)

    fun getNewTask(): String?
    //IRRELEVANT

    fun saveDiskSpace(diskSpace: String?)

    fun getDiskSpace(): String?

    fun saveShortcutInbox()

    fun getShortcutInbox()

    fun saveShowSidebar(sidebar: String?)

    fun getShowSidebar(): String?

    fun saveId()

    fun getId(): String?
}