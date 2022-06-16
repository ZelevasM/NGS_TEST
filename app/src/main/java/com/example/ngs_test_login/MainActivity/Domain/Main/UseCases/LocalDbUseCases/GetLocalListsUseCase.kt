package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class GetLocalListsUseCase(private val mainRepository: MainRepository)
{
    fun execute(): ArrayList<DataList?>?
    {
        return mainRepository.getLocalLists()
    }
}