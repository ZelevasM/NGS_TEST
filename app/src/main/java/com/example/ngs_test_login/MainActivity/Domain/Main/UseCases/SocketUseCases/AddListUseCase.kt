package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface

class AddListUseCase(private val mainInterface: MainInterface)
{
    fun execute(name: String)
    {
        mainInterface.addList(name)
    }
}