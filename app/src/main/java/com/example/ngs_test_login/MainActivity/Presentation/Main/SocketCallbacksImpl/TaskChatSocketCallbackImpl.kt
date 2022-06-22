package com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.TaskChatCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.TasksChatsLocalDbUseCases.*
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.TasksLocalDbUseCases.GetLocalTaskUseCase
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksChatsSocketUseCases.AddTaskMessageUseCase

class TaskChatSocketCallbackImpl(private val mainRepository: MainRepository,
                                private val singleTaskData: MutableLiveData<Task?>): TaskChatCallbackInterface
{
    override fun onMessageAdded(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {
        AddLocalTaskMessageUseCase(mainRepository).execute(taskMessage, taskId, listId)
        //val taskMessages = GetLocalTaskMessageUseCase(mainRepository).execute(taskMessage, taskId, listId)
        singleTaskData.postValue(GetLocalTaskUseCase(mainRepository).execute(taskId,listId!!))
    }

    override fun onMessageDeleted(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {
        DeleteLocalTaskMessageUseCase(mainRepository).execute(taskMessage, taskId, listId)
    }

    override fun onMessageRead(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {
        ReadLocalTaskMessageUseCase(mainRepository).execute(taskMessage, taskId, listId)
    }

    override fun onMessageRenamed(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {
        RenameLocalTaskMessageUseCase(mainRepository).execute(taskMessage, taskId, listId)
    }

    override fun onMessageStartedTyping(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {

    }

    override fun onMessageEndedTyping(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {

    }
}