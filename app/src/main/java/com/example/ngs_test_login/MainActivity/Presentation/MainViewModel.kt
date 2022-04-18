package com.example.ngs_test_login.MainActivity.Presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngs_test_login.MainActivity.Data.Main.MainInterfaceImpl
import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.GetDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel()
{
    private val mainInterface = MainInterfaceImpl()

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        val getDataUseCase = GetDataUseCase(mainInterface)
        getDataUseCase.execute()
    }
}