package com.example.ngs_test_login.MainActivity.Presentation.User.LocalDbProviders

import com.example.ngs_test_login.MainActivity.Data.User.UserInterfaceImpl
import com.example.ngs_test_login.MainActivity.Domain.User.UserLocalDbProviderInterface

class UserLocalDbProvider(private val userInterfaceImpl: UserInterfaceImpl): UserLocalDbProviderInterface
{
    /*DELETE ?*/
    fun saveAll()
    {}

    fun getAll()
    {}
    /*        */

    /// NO NEED?
    override fun saveName()
    {
        TODO("Not yet implemented")
    }

    override fun getName()
    {
        TODO("Not yet implemented")
    }

    override fun saveId()
    {
        TODO("Not yet implemented")
    }

    override fun getId()
    {
        TODO("Not yet implemented")
    }

    override fun saveEmail()
    {
        TODO("Not yet implemented")
    }

    override fun getEmail()
    {
        TODO("Not yet implemented")
    }

    override fun saveLanguage()
    {
        TODO("Not yet implemented")
    }

    override fun getLanguage()
    {
        TODO("Not yet implemented")
    }

    override fun saveShowSidebar()
    {
        TODO("Not yet implemented")
    }

    override fun getShowSidebar()
    {
        TODO("Not yet implemented")
    }

    override fun saveDiskSpace()
    {
        TODO("Not yet implemented")
    }

    override fun getDiskSpace()
    {
        TODO("Not yet implemented")
    }

    override fun saveExpandSubtask()
    {
        TODO("Not yet implemented")
    }

    override fun getExpandSubtask()
    {
        TODO("Not yet implemented")
    }

    override fun saveNewTask()
    {
        TODO("Not yet implemented")
    }

    override fun getNewTask()
    {
        TODO("Not yet implemented")
    }

    override fun saveShortcutInbox()
    {
        TODO("Not yet implemented")
    }

    override fun getShortcutInbox()
    {
        TODO("Not yet implemented")
    }
}