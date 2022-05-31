package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList

class GetLocalListUseCase(private val mainInterface: MainInterface)
{
    fun execute(dataList: DataList)
    {
        mainInterface.getLocalList(dataList)
    }
}