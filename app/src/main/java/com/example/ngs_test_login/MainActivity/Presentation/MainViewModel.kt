package com.example.ngs_test_login.MainActivity.Presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngs_test_login.MainActivity.Data.Main.MainInterfaceImpl
import com.example.ngs_test_login.MainActivity.Data.Main.Web.IdGenerator
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.*
import com.example.ngs_test_login.MainActivity.Domain.Models.*
import com.example.ngs_test_login.MainActivity.Presentation.SocketCallbacksImpl.ChatSocketCallbackImpl
import com.example.ngs_test_login.MainActivity.Presentation.SocketCallbacksImpl.ListSocketCallbackImpl
import com.example.ngs_test_login.MainActivity.Presentation.Validators.ChatValidator
import com.example.ngs_test_login.MainActivity.Presentation.Validators.ListValidator
import com.example.ngs_test_login.MainActivity.Presentation.Validators.ShortcutValidator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel()
{
    //TODO GOVNO CODE
    private val listsData = MutableLiveData<ArrayList<DataList?>?>()
    val listsLiveData: LiveData<ArrayList<DataList?>?> = listsData

    private val chatsData = MutableLiveData<ArrayList<Chat?>?>()
    val chatsLiveData: LiveData<ArrayList<Chat?>?> = chatsData

    private val shortcutsData = MutableLiveData<ArrayList<Shortcut?>?>()
    val shortcutsLiveData: LiveData<ArrayList<Shortcut?>?> = shortcutsData

    private var lists: ArrayList<DataList?>? = null
    private var chats: ArrayList<Chat?>? = null
    //////

    private val mainInterface = MainInterfaceImpl()

    fun getData(){
        viewModelScope.launch(Dispatchers.IO) {
            val getDataUseCase = GetDataUseCase(mainInterface)
            //TODO GOVNO CODE
            val mainData: MainData = getDataUseCase.execute()
            lists = mainData.dataLists
            chats  = mainData.chats
            val user: User? = mainData.user
            val shortcuts: ArrayList<Shortcut?>? = user?.shortcuts as ArrayList<Shortcut?>?

            Log.d("MyLog","lists: $lists")
            Log.d("MyLog","chats: $chats")
            Log.d("MyLog","user: $user")


            if (ListValidator().validateIncomingList(lists))
            {
                listsData.postValue(lists)
                getList()
            }
            if (ChatValidator().validateIncomingChat(chats))
            {
                chatsData.postValue(chats)
                getChat()
            }
            if (ShortcutValidator().validateIncomingShortcut(shortcuts))
            {
                shortcutsData.postValue(shortcuts)
            }
        }
    }

    fun socketInit()
    {
        val socketInitUseCase: SocketInitUseCase = SocketInitUseCase(mainInterface)
        socketInitUseCase.execute()
    }

    fun addList(name: String){
        viewModelScope.launch(Dispatchers.IO){
            val addListUseCase: AddListUseCase = AddListUseCase(mainInterface)
            addListUseCase.execute(name)
        }
    }

    fun getList()
    {
        viewModelScope.launch(Dispatchers.IO){
            val getListUseCase: GetListUseCase = GetListUseCase(mainInterface)
            val listSocketCallbackImpl: ListSocketCallbackImpl = ListSocketCallbackImpl(lists, listsData)
            getListUseCase.execute(listSocketCallbackImpl)
        }
    }

    fun addChat(name: String)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val addChatUseCase: AddChatUseCase = AddChatUseCase(mainInterface)
            addChatUseCase.execute(name)
        }
    }

    fun getChat()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val getChatUseCase: GetChatUseCase = GetChatUseCase(mainInterface)
            val chatSocketCallbackImpl: ChatSocketCallbackImpl = ChatSocketCallbackImpl(chats, chatsData)
            getChatUseCase.execute(chatSocketCallbackImpl)
        }
    }
}