package com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl

import android.util.Log
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.TaskChatCallbackInterface

class TaskChatSocketCallbackImpl(private val mainRepository: MainRepository): TaskChatCallbackInterface
{
    override fun onMessageAdded(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {

    }

    override fun onMessageDeleted(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {

    }

    override fun onMessageRead(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {

    }

    override fun onMessageRenamed(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {

    }

    override fun onMessageStartedTyping(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {

    }

    override fun onMessageEndedTyping(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {

    }
}