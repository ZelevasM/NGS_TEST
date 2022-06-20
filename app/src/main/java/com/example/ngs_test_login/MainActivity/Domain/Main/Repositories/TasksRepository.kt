package com.example.ngs_test_login.MainActivity.Domain.Main.Repositories

import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import io.socket.client.Socket

interface TasksRepository
{
    fun searchTasks()

    fun addLocalTask(task: Task?, listId: String)

    fun doneLocalTask(task: Task?, listId: String)

    fun noteLocalTask(task: Task?, listId: String)

    //fun orderLocalTask(task: Task?, listId: String)

    fun renameLocalTask(task: Task?, listId: String)

    fun deleteLocalTask(task: Task?, listId: String)

    fun getLocalTask(taskId: String?, listId: String): Task?

    //Socket's Methods

    fun socketInit(bSocket: Socket)

    fun addTask(name: String, projectId: String, parentTaskId: String?)

    fun doneTask(id: String, projectId: String, done: Boolean)

    fun noteTask(id: String, projectId: String, notes: String?)

    fun orderTask()

    fun renameTask(id: String, newName: String?,  projectId: String)

    fun deleteTask(id: String, projectId: String)

    fun getTask()
}