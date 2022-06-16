package com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases

import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository

class LocalDbCloseUseCase(private val mainRepository: MainRepository)
{
    fun execute()
    {
        mainRepository.localDbClose()
    }
}