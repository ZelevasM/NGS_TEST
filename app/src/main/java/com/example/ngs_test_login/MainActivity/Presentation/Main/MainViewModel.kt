package com.example.ngs_test_login.MainActivity.Presentation.Main

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngs_test_login.MainActivity.Data.Main.MainInterfaceImpl
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.*
import com.example.ngs_test_login.MainActivity.Domain.Models.*
import com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl.ChatSocketCallbackImpl
import com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl.ListSocketCallbackImpl
import com.example.ngs_test_login.MainActivity.Presentation.Main.Validators.ChatValidator
import com.example.ngs_test_login.MainActivity.Presentation.Main.Validators.ListValidator
import com.example.ngs_test_login.MainActivity.Presentation.User.Validators.ShortcutValidator
import com.example.ngs_test_login.MainActivity.Presentation.ViewModelInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(), ViewModelInterface
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
    private var user: User? = null

    private val mainInterfaceImpl = MainInterfaceImpl()

    fun getData(context: Context)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val getDataUseCase = GetDataUseCase(mainInterfaceImpl)
            val mainData: MainData? = getDataUseCase.execute()
            dataEstablisher(mainData, context)
        }
    }

    fun dataEstablisher(mainData: MainData?,context: Context)
    {
        lists = mainData?.dataLists
        chats = mainData?.chats
        user = mainData?.user
        val shortcuts: ArrayList<Shortcut?>? = user?.shortcuts as ArrayList<Shortcut?>?

        Log.d("MyLog","lists: $lists")
        Log.d("MyLog","chats: $chats")
        Log.d("MyLog","user: $user")

        if (ListValidator().validateIncomingList(lists))
        {
            listsData.postValue(lists)
            //getList()
            //write data to local storage
        } else
        {
            //getList()
        }
        if (ChatValidator().validateIncomingChat(chats))
        {
            chatsData.postValue(chats)
            //getChat()
            //write data to local storage
        } else
        {
            //getChat()
        }
        if (ShortcutValidator().validateIncomingShortcut(shortcuts))
        {
            shortcutsData.postValue(shortcuts)
            //write data to local storage
        }
    }

    override fun socketInit()
    {
        val mainSocketInitUseCase: MainSocketInitUseCase = MainSocketInitUseCase(mainInterfaceImpl)
        mainSocketInitUseCase.execute()
    }

    override fun localDbInit(context: Context)
    {

    }

    override fun localDbClose()
    {

    }

    fun addLocalLists()
    {

    }

    fun getLocalLists()
    {

    }

    fun addLocalChats()
    {
    }

    fun getLocalChat()
    {
    }

    fun addList(name: String)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val addListUseCase: AddListUseCase = AddListUseCase(mainInterfaceImpl)
            addListUseCase.execute(name)
        }
    }

    fun getList()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val getListUseCase: GetListUseCase = GetListUseCase(mainInterfaceImpl)
            val listSocketCallbackImpl: ListSocketCallbackImpl = ListSocketCallbackImpl(lists,
                listsData)
            getListUseCase.execute(listSocketCallbackImpl)
        }
    }

    fun addChat(name: String)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val addChatUseCase: AddChatUseCase = AddChatUseCase(mainInterfaceImpl)
            addChatUseCase.execute(name)
        }
    }

    fun getChat()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val getChatUseCase: GetChatUseCase = GetChatUseCase(mainInterfaceImpl)
            val chatSocketCallbackImpl: ChatSocketCallbackImpl = ChatSocketCallbackImpl(chats,
                chatsData)
            getChatUseCase.execute(chatSocketCallbackImpl)
        }
    }
}
