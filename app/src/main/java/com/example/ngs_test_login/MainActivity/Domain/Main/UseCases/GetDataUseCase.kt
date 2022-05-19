package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.MainData

class GetDataUseCase(private val mainInterface: MainInterface)
{
    fun execute(): MainData?
    {
        return mainInterface.getData()
    }
}