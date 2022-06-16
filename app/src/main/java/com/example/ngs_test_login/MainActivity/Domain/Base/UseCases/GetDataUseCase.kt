package com.example.ngs_test_login.MainActivity.Domain.Base.UseCases

import com.example.ngs_test_login.MainActivity.Domain.Base.Repositories.BaseRepository
import com.example.ngs_test_login.MainActivity.Domain.Base.Models.MainData

class GetDataUseCase(private val baseRepository: BaseRepository)
{
    fun execute(): MainData?
    {
        return baseRepository.getData()
    }
}