package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList

class AddLocalListsUseCase(private val mainInterface: MainInterface)
{
    fun execute(dataLists: ArrayList<DataList?>?)
    {
        mainInterface.addLocalLists(dataLists)
    }
}