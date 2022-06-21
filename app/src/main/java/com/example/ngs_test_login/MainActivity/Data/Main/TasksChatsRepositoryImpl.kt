package com.example.ngs_test_login.MainActivity.Data.Main

import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.ListsDao
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Socket.TaskChatSocket
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.TasksChatsRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.TaskChatCallbackInterface
import io.socket.client.Socket

class TasksChatsRepositoryImpl(private val listsDao: ListsDao): TasksChatsRepository
{
    private lateinit var taskChatSocket: TaskChatSocket

    override fun addLocalTaskMessage()
    {
        TODO("Not yet implemented")
    }

    override fun renameLocalTaskMessage()
    {
        TODO("Not yet implemented")
    }

    override fun deleteLocalTaskMessage()
    {
        TODO("Not yet implemented")
    }

    override fun readLocalTaskMessage()
    {
        TODO("Not yet implemented")
    }

    override fun getLocalTaskMessage()
    {
        TODO("Not yet implemented")
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

    override fun deleteTaskMessage(id: String?,taskId: String?)
    {
        taskChatSocket.deleteTaskMessage(id, taskId)
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