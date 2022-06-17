package com.example.ngs_test_login.MainActivity.Domain.User.Repositories

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserHomepageSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserNewTaskSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserSubtaskSocketCallbackInterface
import io.socket.client.Socket

interface GeneralSettingsRepository
{
    fun saveLocalLanguage(language: String?)

    fun getLocalLanguage(): String?


    fun saveLocalHomepage(homepage: String?)

    fun getLocalHomepage(): String?


    fun saveLocalExpandSubtask(expandSubtask: String?)

    fun getLocalExpandSubtask(): String?


    fun saveLocalNewTask(newTask: String?)

    fun getLocalNewTask(): String?

    //Socket's Methods

    fun socketInit(bSocket: Socket)

    fun changeHomepage(homepage: String?)

    fun onChangedHomepage(userHomeSocketCallbackInterface: UserHomepageSocketCallbackInterface)


    fun changeExpandSubtask(expandSubtask: String?)

    fun onChangedExpandSubtask(userSubtaskSocketCallbackInterface: UserSubtaskSocketCallbackInterface)


    fun changeNewTask(newTask: String?)

    fun onChangedNewTask(userNewTaskSocketCallbackInterface: UserNewTaskSocketCallbackInterface)
}