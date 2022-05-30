package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface

class GetListUseCase(private val mainInterface: MainInterface)
{
    fun execute(listSocketCallbackInterface: ListSocketCallbackInterface)
    {
        mainInterface.getList(listSocketCallbackInterface)
    }
}