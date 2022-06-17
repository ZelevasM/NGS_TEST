package com.example.ngs_test_login.MainActivity.Data.User

import com.example.ngs_test_login.MainActivity.Data.User.Local.UserDao
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.GeneralSettingsRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserHomepageSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserNewTaskSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserSubtaskSocketCallbackInterface

class GeneralSettingsRepositoryImpl(private val userDao: UserDao): GeneralSettingsRepository
{
    override fun saveLocalLanguage(language: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalLanguage(): String?
    {
        TODO("Not yet implemented")
    }

    override fun saveLocalHomepage(homepage: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalHomepage(): String?
    {
        TODO("Not yet implemented")
    }

    override fun saveLocalExpandSubtask(expandSubtask: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalExpandSubtask(): String?
    {
        TODO("Not yet implemented")
    }

    override fun saveLocalNewTask(newTask: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalNewTask(): String?
    {
        TODO("Not yet implemented")
    }

    //Socket's Methods

    override fun changeHomepage(homepage: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedHomepage(userHomeSocketCallbackInterface: UserHomepageSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }

    override fun changeExpandSubtask(expandSubtask: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedExpandSubtask(userSubtaskSocketCallbackInterface: UserSubtaskSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }

    override fun changeNewTask(newTask: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedNewTask(userNewTaskSocketCallbackInterface: UserNewTaskSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }
}