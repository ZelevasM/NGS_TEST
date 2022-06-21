package com.example.ngs_test_login.MainActivity.Data.Main

import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.ListsDao
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Socket.TaskSocket
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.TasksRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.TaskSocketCallbackInterface
import io.socket.client.Socket

class TasksRepositoryImpl(private val listsDao: ListsDao): TasksRepository
{
    private lateinit var taskSocket: TaskSocket

    override fun searchTasks()
    {
        TODO("Not yet implemented")
    }

    override fun addLocalTask(task: Task?,listId: String?)
    {
        val tasks = listsDao.getList(listId)?.tasks
        tasks?.add(task)
        listsDao.updateTask(tasks, listId)
    }

    override fun doneLocalTask(task: Task?,listId: String?)
    {
        val tasks = listsDao.getList(listId)?.tasks
        if (tasks != null)
        {
            for(i in tasks.indices)
            {
                if (tasks[i]?.id == task?.id) tasks[i]?.done = task?.done
            }
        }
        listsDao.updateTask(tasks, listId)
    }

    override fun noteLocalTask(task: Task?,listId: String?)
    {
        val tasks = listsDao.getList(listId)?.tasks
        if (tasks != null)
        {
            for(i in tasks.indices)
            {
                if (tasks[i]?.id == task?.id) tasks[i]?.notes = task?.notes
            }
        }
        listsDao.updateTask(tasks, listId)
    }

    override fun renameLocalTask(task: Task?,listId: String?)
    {
        val tasks = listsDao.getList(listId)?.tasks
        if (tasks != null)
        {
            for(i in tasks.indices)
            {
                if (tasks[i]?.id == task?.id) tasks[i]?.name = task?.name
            }
        }
        listsDao.updateTask(tasks, listId)
    }

    override fun deleteLocalTask(task: Task?,listId: String?)
    {
        val tasks = listsDao.getList(listId)?.tasks
        if(tasks != null)
        {
            Log.d("MyLog","tasks size: ${tasks.size}")
            for(i in 0 until tasks.size)
            {
                Log.d("MyLog","position: ${i}")
                if(tasks[i]?.id == task?.id)
                {
                    tasks.removeAt(i)
                    break
                }
            }
        }
        listsDao.updateTask(tasks, listId)
    }

    override fun getLocalTask(taskId: String?,listId: String?): Task?
    {
        val tasks: ArrayList<Task?>? = listsDao.getList(listId)?.tasks
        var resultTask: Task? = null
        if (tasks != null)
        {
            for(i in tasks)
            {
                if(i?.id == taskId)
                    resultTask = i
            }
        }
        return resultTask
    }

    //Socket's Methods

    override fun socketInit(bSocket: Socket)
    {
        taskSocket = TaskSocket(bSocket)
    }

    override fun addTask(name: String,projectId: String,parentTaskId: String?)
    {
        taskSocket.addTask(name, projectId,parentTaskId)
    }

    override fun doneTask(id: String,projectId: String,done: Boolean)
    {
        taskSocket.doneTask(id, projectId, done)
    }

    override fun noteTask(id: String,projectId: String,notes: String?)
    {
        taskSocket.noteTask(id, projectId, notes)
    }

    override fun orderTask()
    {
        TODO("Not yet implemented")
    }

    override fun renameTask(id: String, newName: String?,  projectId: String)
    {
        taskSocket.renameTask(id, newName, projectId)
    }

    override fun deleteTask(id: String, projectId: String)
    {
        taskSocket.deleteTask(id, projectId)
    }

    override fun getTask(taskSocketCallbackInterface: TaskSocketCallbackInterface)
    {
        taskSocket.getTask(taskSocketCallbackInterface)
    }
}