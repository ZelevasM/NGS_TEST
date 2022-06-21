package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.TasksLocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class NoteLocalTaskUseCase(private val mainRepository: MainRepository)
{
    fun execute(task: Task?,listId: String?)
    {
        mainRepository.noteLocalTask(task, listId)
    }
}