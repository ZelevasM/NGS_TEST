package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class AddLocalListsUseCase(private val mainRepository: MainRepository)
{
    fun execute(dataLists: ArrayList<DataList?>?)
    {
        mainRepository.addLocalLists(dataLists)
    }
}