package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList

class GetLocalListUseCase(private val mainRepository: MainRepository)
{
    fun execute(dataList: DataList)
    {
        mainRepository.getLocalList(dataList)
    }
}