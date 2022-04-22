package com.example.ngs_test_login.MainActivity.Presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngs_test_login.MainActivity.Data.Main.MainInterfaceImpl
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.GetDataUseCase
import com.example.ngs_test_login.MainActivity.Domain.Models.*
import com.example.ngs_test_login.MainActivity.Presentation.Validators.ChatValidator
import com.example.ngs_test_login.MainActivity.Presentation.Validators.ListValidator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class MainViewModel: ViewModel()
{
    //TODO GOVNO CODE
    private val listsData = MutableLiveData<ArrayList<DataList?>?>()
    val listsLiveData: LiveData<ArrayList<DataList?>?> = listsData

    private val chatsData = MutableLiveData<ArrayList<Chat?>?>()
    val chatsLiveData: LiveData<ArrayList<Chat?>?> = chatsData

    private val shortcutsData = MutableLiveData<ArrayList<Shortcut?>?>()
    val shortcutsLiveData: LiveData<ArrayList<Shortcut?>?> = shortcutsData

    //////

    private val mainInterface = MainInterfaceImpl()

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        val getDataUseCase = GetDataUseCase(mainInterface)

        //TODO GOVNO CODE
        val mainData: MainData = getDataUseCase.execute()
        val lists: ArrayList<DataList?>? = mainData.dataLists
        val chats: ArrayList<Chat?>? = mainData.chats
        val user: User? = mainData.user
        Log.d("MyLog","lists: $lists")
        Log.d("MyLog","chats: $chats")
        Log.d("MyLog","user: $user")


        if (ListValidator().validateIncomingList(lists))
        {
            listsData.postValue(lists)
        }
        if (ChatValidator().validateIncomingChat(chats))
        {
            chatsData.postValue(chats)
        }
    }
}