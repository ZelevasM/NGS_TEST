package com.example.ngs_test_login.MainActivity.Presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngs_test_login.MainActivity.Data.Main.MainInterfaceImpl
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.GetDataUseCase
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList
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