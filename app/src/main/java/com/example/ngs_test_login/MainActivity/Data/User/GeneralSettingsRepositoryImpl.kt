package com.example.ngs_test_login.MainActivity.Data.User

import com.example.ngs_test_login.MainActivity.Data.User.Local.UserDao
import com.example.ngs_test_login.MainActivity.Data.User.Web.UserSocket
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Homepage
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.GeneralSettingsRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserHomepageSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserNewTaskSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserSubtaskSocketCallbackInterface
import io.socket.client.Socket

class GeneralSettingsRepositoryImpl(private val userDao: UserDao): GeneralSettingsRepository
{
    private lateinit var userSocket: UserSocket
    //TODO Match incoming variables exactly to User Entity's parameters both for sockets and local
    override fun saveLocalLanguage(language: String?)
    {
        userDao.updateLanguage(language)
    }

    override fun getLocalLanguage(): String?
    {
        return userDao.getLanguage()
    }

    override fun saveLocalHomepage(homepage: String?)
    {
        userDao.updateHomepage(homepage)
    }

    override fun getLocalHomepage(): String?
    {
        return userDao.getHomepage()
    }

    override fun saveLocalExpandSubtask(expandSubtask: String?)
    {
        userDao.updateExpandSubtask(expandSubtask?.toBoolean())
    }

    override fun getLocalExpandSubtask(): String?
    {
       return userDao.getExpandSubtask()?.toString()
    }

    override fun saveLocalNewTask(newTask: String?)
    {
        userDao.updateNewTask(newTask?.toBoolean())
    }

    override fun getLocalNewTask(): String?
    {
        return userDao.getNewTask()?.toString()
    }

    //Socket's Methods

    override fun socketInit(bSocket: Socket)
    {
        userSocket = UserSocket(bSocket)
    }

    override fun changeHomepage(homepage: String?)
    {
        userSocket.changeHomepage(homepage)
    }

    override fun onChangedHomepage(userHomeSocketCallbackInterface: UserHomepageSocketCallbackInterface)
    {
        userSocket.onChangedHomepage(userHomeSocketCallbackInterface)
    }

    override fun changeExpandSubtask(expandSubtask: String?)
    {
        userSocket.changeExpandSubtask(expandSubtask)
    }

    override fun onChangedExpandSubtask(userSubtaskSocketCallbackInterface: UserSubtaskSocketCallbackInterface)
    {
        userSocket.onChangedExpandSubtask(userSubtaskSocketCallbackInterface)
    }

    override fun changeNewTask(newTask: String?)
    {
        userSocket.changeNewTask(newTask)
    }

    override fun onChangedNewTask(userNewTaskSocketCallbackInterface: UserNewTaskSocketCallbackInterface)
    {
        userSocket.onChangedNewTask(userNewTaskSocketCallbackInterface)
    }
}