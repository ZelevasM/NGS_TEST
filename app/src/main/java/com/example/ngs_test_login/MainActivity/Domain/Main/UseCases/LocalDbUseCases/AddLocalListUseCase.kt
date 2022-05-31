package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList

class AddLocalListUseCase(private val mainInterface: MainInterface)
{
    fun execute(dataList: DataList)
    {
        mainInterface.addLocalList(dataList)
    }
}