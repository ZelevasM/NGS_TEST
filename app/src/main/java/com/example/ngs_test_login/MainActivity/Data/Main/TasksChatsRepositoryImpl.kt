package com.example.ngs_test_login.MainActivity.Data.Main

import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.ListsDao
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Socket.TaskChatSocket
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.TasksChatsRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.TaskChatCallbackInterface
import io.socket.client.Socket

class TasksChatsRepositoryImpl(private val listsDao: ListsDao): TasksChatsRepository
{
    private lateinit var taskChatSocket: TaskChatSocket

    override fun addLocalTaskMessage(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {
        val list = listsDao.getList(listId)
        val tasks = list?.tasks
        if(tasks != null)
        {
            for(i in tasks.indices)
            {
                if(tasks[i]?.id == taskId)
                {
                    tasks[i]?.messages?.add(taskMessage)
                    break
                }
            }
        }
        listsDao.updateTask(tasks as ArrayList<Task?>?, listId)
    }

    override fun renameLocalTaskMessage(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {
        val list = listsDao.getList(listId)
        val tasks = list?.tasks
        if(tasks != null)
        {
            for(i in tasks.indices)
            {
                if(tasks[i]?.id == taskId)
                {
                    if(tasks[i]?.messages != null)
                    {
                        for(k in tasks[i]?.messages?.indices!!)
                        {
                            if(tasks[i]?.messages?.get(k)?.id == taskMessage?.id)
                            {
                                tasks[i]?.messages?.get(k)?.message = taskMessage?.message
                                break
                            }
                        }
                    }
                }
            }
        }
        listsDao.updateTask(tasks as ArrayList<Task?>?, listId)
    }

    override fun deleteLocalTaskMessage(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {
        val list = listsDao.getList(listId)
        val tasks = list?.tasks
        if(tasks != null)
        {
            for(i in tasks.indices)
            {
                if(tasks[i]?.id == taskId)
                {
                    if(tasks[i]?.messages != null)
                    {
                        for(k in tasks[i]?.messages?.indices!!)
                        {
                            if(tasks[i]?.messages?.get(k)?.id == taskMessage?.id)
                            {
                                tasks[i]?.messages?.removeAt(k)
                                break
                            }
                        }
                    }
                }
            }
        }
        listsDao?.updateTask(tasks as ArrayList<Task?>?, listId)
    }

    override fun readLocalTaskMessage(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {
        val list = listsDao.getList(listId)
        val tasks = list?.tasks
        if(tasks != null)
        {
            for(i in tasks.indices)
            {
                if(tasks[i]?.id == taskId)
                {
                    if(tasks[i]?.messages != null)
                    {
                        for(k in tasks[i]?.messages?.indices!!)
                        {
                            if(tasks[i]?.messages?.get(k)?.id == taskMessage?.id)
                            {
                                tasks[i]?.messages?.get(k)?.read = taskMessage?.read
                                break
                            }
                        }
                    }
                }
            }
        }
        listsDao.updateTask(tasks as ArrayList<Task?>?, listId)
    }

    override fun getLocalTaskMessage(taskMessage: TaskMessage?,taskId: String?,listId: String?): TaskMessage?
    {
        val list = listsDao.getList(listId)
        val tasks = list?.tasks
        var resultTaskMessage: TaskMessage? = null
        if(tasks != null)
        {
            for(i in tasks.indices)
            {
                if(tasks[i]?.id == taskId)
                {
                    if(tasks[i]?.messages != null)
                    {
                        for(k in tasks[i]?.messages?.indices!!)
                        {
                            if(tasks[i]?.messages?.get(k)?.id == taskMessage?.id)
                            {
                                resultTaskMessage = tasks[i]?.messages?.get(k)
                                break
                            }
                        }
                    }
                }
            }
        }
        return resultTaskMessage
    }

    //Socket's Methods

    override fun socketInit(bSocket: Socket)
    {
        taskChatSocket = TaskChatSocket(bSocket)
    }

    override fun addTaskMessage(userId: String?,taskId: String?,listId: String?,message: String?,replyChatId: String?,fileId: String?)
    {
        taskChatSocket.addTaskMessage(userId, taskId, listId, message, replyChatId, fileId)
    }

    override fun renameTaskMessage(id: String?,taskId: String?,listId: String?,message: String?)
    {
        taskChatSocket.renameTaskMessage(id, taskId, listId, message)
    }

    override fun deleteTaskMessage(id: String?,taskId: String?,listId: String?)
    {
        taskChatSocket.deleteTaskMessage(id, taskId, listId)
    }

    override fun readTaskMessage(id: String?,taskId: String?,userId: String?,allRead: Boolean?)
    {
        taskChatSocket.readTaskMessage(id, taskId, userId, allRead)
    }

    override fun startTypingTaskMessage()
    {
        taskChatSocket.startTypingMessage()
    }

    override fun endTypingTaskMessage()
    {
        taskChatSocket.endTypingMessage()
    }

    override fun getTaskMessage(taskChatCallbackInterface: TaskChatCallbackInterface)
    {
        taskChatSocket.getTaskMessage(taskChatCallbackInterface)
    }
}