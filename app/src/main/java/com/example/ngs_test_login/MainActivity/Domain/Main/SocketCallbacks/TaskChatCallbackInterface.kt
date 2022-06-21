package com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks

import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage

interface TaskChatCallbackInterface
{
    fun onMessageAdded(taskMessage: TaskMessage?, taskId: String?, listId: String?)

    fun onMessageDeleted(taskMessage: TaskMessage?, taskId: String?, listId: String?)

    fun onMessageRead(taskMessage: TaskMessage?, taskId: String?, listId: String?)

    fun onMessageRenamed(taskMessage: TaskMessage?, taskId: String?, listId: String?)

    fun onMessageStartedTyping(taskMessage: TaskMessage?, taskId: String?, listId: String?)

    fun onMessageEndedTyping(taskMessage: TaskMessage?, taskId: String?, listId: String?)
}