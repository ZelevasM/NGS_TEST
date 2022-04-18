package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface

class GetDataUseCase(private val mainInterface: MainInterface)
{
    fun execute()
    {
        mainInterface.getData()
    }
}