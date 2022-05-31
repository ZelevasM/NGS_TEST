package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface

class DeleteListUseCase(private val mainInterface: MainInterface)
{
    fun execute(id: String)
    {
        mainInterface.deleteList(id)
    }
}