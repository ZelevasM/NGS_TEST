package com.example.ngs_test_login.MainActivity.Presentation.Main

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ngs_test_login.MainActivity.Data.Main.MainRepositoryImpl
import com.example.ngs_test_login.MainActivity.Domain.Base.Models.MainData
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.Chat
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.LocalDbUseCases.*
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.*
import com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl.ChatSocketCallbackImpl
import com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl.ListSocketCallbackImpl
import com.example.ngs_test_login.MainActivity.Presentation.Main.Validators.ChatValidator
import com.example.ngs_test_login.MainActivity.Presentation.Main.Validators.ListValidator
import com.example.ngs_test_login.MainActivity.Presentation.ViewModelInterface
import io.socket.client.Socket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(), ViewModelInterface
{
    //TODO GOVNO CODE
    private val listsData = MutableLiveData<ArrayList<DataList?>?>()
    val listsLiveData: LiveData<ArrayList<DataList?>?> = listsData

    private val chatsData = MutableLiveData<ArrayList<Chat?>?>()
    val chatsLiveData: LiveData<ArrayList<Chat?>?> = chatsData

    private var lists: ArrayList<DataList?>? = null
    private var chatWebs: ArrayList<Chat?>? = null

    //TODO Change
    private var currentListName: String? = null
    private var currentListID: String? = null

    private val mainInterfaceImpl = MainRepositoryImpl()


    //LOCAL DB METHODS
    //LISTS' METHODS
    override fun localDbInit(context: Context)
    {
        val localDbInitUseCase: LocalDbInitUseCase = LocalDbInitUseCase(mainInterfaceImpl)
        localDbInitUseCase.execute(context)

        dataAtomicAssigner()
    }

    override fun localDbClose()
    {
        val localDbCloseUseCase: LocalDbCloseUseCase = LocalDbCloseUseCase(mainInterfaceImpl)
        localDbCloseUseCase.execute()
    }

    fun dataAtomicAssigner()
    {
        lists = getLocalListsAtomic()
        chatWebs = getLocalChatsAtomic()
        //chats = mainData?.chats

        Log.d("MyLog","lists: $lists")
        //Log.d("MyLog","chats: $chats")

        if (ListValidator().validateIncomingList(lists))
        {
            listsData.postValue(lists)
        }
        if (ChatValidator().validateIncomingChat(chatWebs))
        {
            chatsData.postValue(chatWebs)
        }
    }

    fun addLocalListsAtomic(mainData: MainData?)
    {
        val addLocalListsUseCase: AddLocalListsUseCase = AddLocalListsUseCase(mainInterfaceImpl)
        addLocalListsUseCase.execute(mainData?.dataLists)
    }

    fun getLocalListsAtomic(): ArrayList<DataList?>?
    {
        val getLocalListsUseCase: GetLocalListsUseCase = GetLocalListsUseCase(mainInterfaceImpl)
        return getLocalListsUseCase.execute()
    }

    fun addLocalChatsAtomic(mainData: MainData?)
    {
        val addLocalChatsUseCase: AddLocalChatsUseCase = AddLocalChatsUseCase(mainInterfaceImpl)
        addLocalChatsUseCase.execute(mainData?.chats)
    }

    fun getLocalChatsAtomic(): ArrayList<Chat?>?
    {
        val getLocalChatsUseCase: GetLocalChatsUseCase = GetLocalChatsUseCase(mainInterfaceImpl)
        return getLocalChatsUseCase.execute()
    }

    //LISTS' METHODS
    override fun socketInit(vararg bSocket: Socket)
    {
        val mainSocketInitUseCase: MainSocketInitUseCase = MainSocketInitUseCase(mainInterfaceImpl)
        mainSocketInitUseCase.execute(bSocket[0])
        invokeSocket()
    }

    fun addList(name: String)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val addListUseCase: AddListUseCase = AddListUseCase(mainInterfaceImpl)
            addListUseCase.execute(name)
        }
    }

    fun updateList(id: String, newName: String)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val updateListUseCase: UpdateListUseCase = UpdateListUseCase(mainInterfaceImpl)
            updateListUseCase.execute(id, newName)
        }
    }

    fun deleteList(id: String)
    {
        viewModelScope.launch(Dispatchers.IO) {
            val deleteListsUseCase: DeleteListUseCase = DeleteListUseCase(mainInterfaceImpl)
            deleteListsUseCase.execute(id)
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

    //CHAT' METHODS
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
            val chatSocketCallbackImpl: ChatSocketCallbackImpl = ChatSocketCallbackImpl(chatWebs,
                chatsData)
            getChatUseCase.execute(chatSocketCallbackImpl)
        }
    }

    fun invokeSocket()
    {
        getList()
        getChat()
    }

    //UI methods
    //TODO Change
    fun setCurrentList(id: String?, name: String?)
    {
        currentListID = id
        currentListName = name
    }

    fun getCurrentListName(): String?{return currentListName}
    fun getCurrentListID(): String?{return currentListID}
}
