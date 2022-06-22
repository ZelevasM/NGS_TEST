package com.example.ngs_test_login.MainActivity.Domain.Main.Repositories

import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.TaskChatCallbackInterface
import io.socket.client.Socket

interface TasksChatsRepository
{
    fun addLocalTaskMessage(taskMessage: TaskMessage?, taskId: String?, listId: String?)

    fun renameLocalTaskMessage(taskMessage: TaskMessage?, taskId: String?, listId: String?)

    fun deleteLocalTaskMessage(taskMessage: TaskMessage?, taskId: String?, listId: String?)

    fun readLocalTaskMessage(taskMessage: TaskMessage?, taskId: String?, listId: String?)

    fun getLocalTaskMessage(taskMessage: TaskMessage?, taskId: String?, listId: String?): TaskMessage?

    //Socket's Methods

    fun socketInit(bSocket: Socket)

    fun addTaskMessage(userId: String?, taskId: String?, listId: String?, message: String?, replyChatId: String?, fileId: String?)

    fun renameTaskMessage(id: String?, taskId: String?, listId: String?, message: String?)

    fun deleteTaskMessage(id: String?, taskId: String?)

    fun readTaskMessage(id: String?, taskId: String?, userId: String?, allRead: Boolean?)

    fun startTypingTaskMessage()

    fun endTypingTaskMessage()

    fun getTaskMessage(taskChatCallbackInterface: TaskChatCallbackInterface)
}