package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksSocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class NotesTaskUseCase(private val mainRepository: MainRepository)
{
    fun execute(id: String, projectId: String, notes: String?)
    {
        mainRepository.noteTask(id, projectId, notes)
    }
}