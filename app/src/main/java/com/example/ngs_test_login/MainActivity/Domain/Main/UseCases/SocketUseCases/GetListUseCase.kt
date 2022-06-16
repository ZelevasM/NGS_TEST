package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface

class GetListUseCase(private val mainRepository: MainRepository)
{
    fun execute(listSocketCallbackInterface: ListSocketCallbackInterface)
    {
        mainRepository.getList(listSocketCallbackInterface)
    }
}