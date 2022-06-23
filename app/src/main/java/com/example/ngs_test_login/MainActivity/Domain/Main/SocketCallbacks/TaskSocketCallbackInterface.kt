package com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks

import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task

interface TaskSocketCallbackInterface
{
    fun onAdded(task: Task?, listId: String?)

    fun onDone(task: Task?, listId: String?)

    fun onAssigned(task: Task?, listId: String?, userId: String?)

    fun onReminded(task: Task?, listId: String?, remind: String?)

    fun onDate(task: Task?, listId: String?, date: String?)

    fun onNote(task: Task?, listId: String?)

    fun onOrdered(task: Task?, listId: String?)

    fun onRenamed(task: Task?, listId: String?)

    fun onDeleted(task: Task?, listId: String?)
}