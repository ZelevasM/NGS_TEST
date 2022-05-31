package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface

class UpdateListUseCase(private val mainInterface: MainInterface)
{
    fun execute(id: String, newName: String)
    {
        mainInterface.updateList(id, newName)
    }
}