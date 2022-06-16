package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class UpdateListUseCase(private val mainRepository: MainRepository)
{
    fun execute(id: String, newName: String)
    {
        mainRepository.updateList(id, newName)
    }
}