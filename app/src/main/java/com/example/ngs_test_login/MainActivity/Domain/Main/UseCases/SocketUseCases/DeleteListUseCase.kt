package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class DeleteListUseCase(private val mainRepository: MainRepository)
{
    fun execute(id: String)
    {
        mainRepository.deleteList(id)
    }
}