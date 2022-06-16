package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class AddListUseCase(private val mainRepository: MainRepository)
{
    fun execute(name: String)
    {
        mainRepository.addList(name)
    }
}