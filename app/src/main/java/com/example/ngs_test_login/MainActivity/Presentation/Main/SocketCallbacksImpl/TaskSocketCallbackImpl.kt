package com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl

import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.TaskSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.TasksLocalDbUseCases.*
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksSocketUseCases.OrderTaskUseCase

class TaskSocketCallbackImpl(private val tasks: ArrayList<Task?>?,
                            private val tasksData: MutableLiveData<ArrayList<Task?>?>,
                            private val mainRepository: MainRepository): TaskSocketCallbackInterface
{
    override fun onAdded(task: Task?,listId: String)
    {
        AddLocalTaskUseCase(mainRepository).execute(task, listId)
    }

    override fun onDone(task: Task?,listId: String)
    {
        DoneLocalTaskUseCase(mainRepository).execute(task, listId)
    }

    override fun onNote(task: Task?,listId: String)
    {
        NoteLocalTaskUseCase(mainRepository).execute(task, listId)
    }

    override fun onOrdered(task: Task?,listId: String)
    {
        TODO("add use case")
    }

    override fun onRenamed(task: Task?,listId: String)
    {
        RenameLocalTaskUseCase(mainRepository).execute(task, listId)
    }

    override fun onDeleted(task: Task?,listId: String)
    {
        DeleteLocalTaskUseCase(mainRepository).execute(task, listId)
    }
}