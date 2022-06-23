package com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.TaskSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.GetLocalListUseCase
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.TasksLocalDbUseCases.*

class TaskSocketCallbackImpl(private val singleTaskData: MutableLiveData<Task?>,
                             private val singleListData: MutableLiveData<DataList?>,
                             private val mainRepository: MainRepository): TaskSocketCallbackInterface
{
    override fun onAdded(task: Task?,listId: String?)
    {
        AddLocalTaskUseCase(mainRepository).execute(task, listId)
        //TODO fetch tasks from local storage and remove current CurrentList's Logic
        val tempList = DataList(id = listId!!)
        singleListData.postValue(GetLocalListUseCase(mainRepository).execute(tempList))
    }

    override fun onDone(task: Task?,listId: String?)
    {
        DoneLocalTaskUseCase(mainRepository).execute(task, listId)
        val tempList = DataList(id = listId!!)
        singleListData.postValue(GetLocalListUseCase(mainRepository).execute(tempList))
    }

    override fun onAssigned(task: Task?,listId: String?,userId: String?)
    {

    }

    override fun onReminded(task: Task?,listId: String?,remind: String?)
    {

    }

    override fun onDate(task: Task?,listId: String?,date: String?)
    {

    }

    override fun onNote(task: Task?,listId: String?)
    {
        NoteLocalTaskUseCase(mainRepository).execute(task, listId)
        val tempList = DataList(id = listId!!)
        singleTaskData.postValue(GetLocalTaskUseCase(mainRepository).execute(taskId = task?.id, listId = listId))
    }

    override fun onOrdered(task: Task?,listId: String?)
    {
        TODO("add use case")
    }

    override fun onRenamed(task: Task?,listId: String?)
    {
        RenameLocalTaskUseCase(mainRepository).execute(task, listId)
        val tempList = DataList(id = listId!!)
        singleListData.postValue(GetLocalListUseCase(mainRepository).execute(tempList))
    }

    override fun onDeleted(task: Task?,listId: String?)
    {
        DeleteLocalTaskUseCase(mainRepository).execute(task, listId)
        val tempList = DataList(id = listId!!)
        singleListData.postValue(GetLocalListUseCase(mainRepository).execute(tempList))
    }
}