package com.example.ngs_test_login.MainActivity.Domain.Base.UseCases

import com.example.ngs_test_login.MainActivity.Domain.Base.BaseInterface
import com.example.ngs_test_login.MainActivity.Domain.Base.Models.MainData

class GetDataUseCase(private val baseInterface: BaseInterface)
{
    fun execute(): MainData?
    {
        return baseInterface.getData()
    }
}