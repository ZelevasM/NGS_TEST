package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksSocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class RenameTaskUseCase(private val mainRepository: MainRepository)
{
    fun execute(id: String, newName: String?,  projectId: String)
    {
        mainRepository.renameTask(id, newName, projectId)
    }
}