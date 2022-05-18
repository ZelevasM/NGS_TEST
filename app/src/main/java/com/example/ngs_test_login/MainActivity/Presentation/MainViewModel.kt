package com.example.ngs_test_login.MainActivity.Presentation

import android.content.Context
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
import com.example.ngs_test_login.MainActivity.Presentation.Validators.UserValidator
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
    private var user: User? = null
    //////

    private val mainInterface = MainInterfaceImpl()

    fun getData(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            //Get Data From Local Storage
            //If Local Data exists, retrieve it, and continue to get newer data from REST
            //If Local Data does not exist, create Local Db, and continue to get newer data from REST
            val newlyCreated: Boolean? = localDbInit(context)
            if(newlyCreated == false)
            {
                //retrieve data from Local Storage
                //read method i guess
                Log.d("LocalDb","=== FROM EXISTED LOCAL STORAGE ===")
                user = getLocalUser()
                Log.d("LocalDb","=== LOCAL EXISTED USER ===\n $user")
            }

            val getDataUseCase = GetDataUseCase(mainInterface)
            //TODO GOVNO CODE
            val mainData: MainData = getDataUseCase.execute()
            lists = mainData.dataLists
            chats  = mainData.chats
            user = mainData.user
            val shortcuts: ArrayList<Shortcut?>? = user?.shortcuts as ArrayList<Shortcut?>?

            Log.d("MyLog","lists: $lists")
            Log.d("MyLog","chats: $chats")
            Log.d("MyLog","user: $user")

            //if(localdata == 1) {fetch it + checker = true} -> and then just continue code
            if (ListValidator().validateIncomingList(lists))
            {
                listsData.postValue(lists)
                getList()
                //write data to local storage
            }
            else{ getList() }
            if (ChatValidator().validateIncomingChat(chats))
            {
                chatsData.postValue(chats)
                getChat()
                //write data to local storage
            }
            else{ getChat() }
            if (ShortcutValidator().validateIncomingShortcut(shortcuts))
            {
                shortcutsData.postValue(shortcuts)
                //write data to local storage
            }
            else{  }
            if(UserValidator().validateIncomingUser(user))
            {
                //write data to local storage
                addLocalUser(context, user)
                //delete then
                Log.d("LocalDb","=== FROM RENEWED LOCAL STORAGE ===")
                getLocalUser()
            }
            else{ }
        }
    }

    fun localDbInit(context: Context): Boolean?
    {
        val localDbInitUseCase: LocalDbInitUseCase = LocalDbInitUseCase(mainInterface)
        val newlyCreated: Boolean? = localDbInitUseCase.execute(context)
        return newlyCreated
    }

    fun localDbClose()
    {
        val localDbCloseUseCase: LocalDbCloseUseCase = LocalDbCloseUseCase(mainInterface)
        localDbCloseUseCase.execute()
    }

    fun addLocalUser(context: Context, user: User?)
    {
        val addLocalUserUseCase: AddLocalUserUseCase = AddLocalUserUseCase(mainInterface)
        addLocalUserUseCase.execute(context, user)
    }

    fun getLocalUser(): User?
    {
        val getLocalUserUseCase: GetLocalUserUseCase = GetLocalUserUseCase(mainInterface)
        val user: User? = getLocalUserUseCase.execute()
        return user
    }

    fun addLocalLists()
    {

    }

    fun getLocalLists()
    {

    }

    fun addLocalChats()
    {}

    fun getLocalChat()
    {}

    fun getLocalShortcuts()
    {}

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

    private fun getList()
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

    private fun getChat()
    {
        viewModelScope.launch(Dispatchers.IO) {
            val getChatUseCase: GetChatUseCase = GetChatUseCase(mainInterface)
            val chatSocketCallbackImpl: ChatSocketCallbackImpl = ChatSocketCallbackImpl(chats, chatsData)
            getChatUseCase.execute(chatSocketCallbackImpl)
        }
    }
}