package com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.AddLocalListUseCase
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.DeleteLocalListUseCase
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.GetLocalListsUseCase
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.UpdateLocalListUseCase

class ListSocketCallbackImpl(private var lists: ArrayList<DataList?>?,
                             private var listsData: MutableLiveData<ArrayList<DataList?>?>,
                                private val mainRepository: MainRepository):
    ListSocketCallbackInterface
{
    override fun onAdded(list: DataList?)
    {
        AddLocalListUseCase(mainRepository).execute(list)
        lists = GetLocalListsUseCase(mainRepository).execute()
        listsData.postValue(lists)
        Log.d("MyLog","List ADDDEEED")
    }

    override fun onUpdated(list: DataList?)
    {
        UpdateLocalListUseCase(mainRepository).execute(list)
        lists = GetLocalListsUseCase(mainRepository).execute()
        listsData.postValue(lists)
        Log.d("MyLog","List UPDATEEED")
    }

    override fun onDeleted(list: DataList?)
    {
        DeleteLocalListUseCase(mainRepository).execute(list)
        lists = GetLocalListsUseCase(mainRepository).execute()
        listsData.postValue(lists)
        Log.d("MyLog","List DELETEEED")
    }
}