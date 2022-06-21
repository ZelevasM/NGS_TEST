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
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksChatsSocketUseCases.*
import com.example.ngs_test_login.MainActivity.Domain.Main.UseCases.SocketUseCases.TasksSocketUseCases.*
import com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl.ChatSocketCallbackImpl
import com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl.ListSocketCallbackImpl
import com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl.TaskChatSocketCallbackImpl
import com.example.ngs_test_login.MainActivity.Presentation.Main.SocketCallbacksImpl.TaskSocketCallbackImpl
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
    private var currentList: DataList? = null
    private var currentListName: String? = null
    private var currentListID: String? = null
    private var currentTaskName: String? = null
    private var currentTaskID: String? = null
    private val singleListData = MutableLiveData<DataList?>()
    val singleListLiveData: LiveData<DataList?> = singleListData

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

    fun getLocalList(dataList: DataList)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            currentList = GetLocalListUseCase(mainInterfaceImpl).execute(dataList)
            singleListData.postValue(currentList)
        }
    }

    //TASK'S METHODS
    fun addTask(name: String, projectId: String, parentTaskId: String?)
    {
        viewModelScope.launch(Dispatchers.IO) { AddTaskUseCase(mainInterfaceImpl).execute(name, projectId, parentTaskId) }
    }

    fun doneTask(id: String, projectId: String, done: Boolean)
    {
        viewModelScope.launch(Dispatchers.IO) { DoneTaskUseCase(mainInterfaceImpl).execute(id, projectId, done) }
    }

    fun noteTask(id: String, projectId: String, notes: String?)
    {
        viewModelScope.launch(Dispatchers.IO) { NotesTaskUseCase(mainInterfaceImpl).execute(id, projectId, notes) }
    }

    fun orderTask()
    {

    }

    fun renameTask(id: String, newName: String?,  projectId: String)
    {
        viewModelScope.launch(Dispatchers.IO) { RenameTaskUseCase(mainInterfaceImpl).execute(id, newName, projectId) }
    }

    fun deleteTask(id: String, projectId: String)
    {
        viewModelScope.launch(Dispatchers.IO) { DeleteTaskUseCase(mainInterfaceImpl).execute(id, projectId) }
    }

    fun getTask()
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            val taskSocketCallbackImpl = TaskSocketCallbackImpl(currentList, singleListData, mainInterfaceImpl)
            GetTaskUseCase(mainInterfaceImpl).execute(taskSocketCallbackImpl)
        }
    }

    //TASKS' CHATS' METHODS

    fun addTaskMessage(userId: String?, taskId: String?, listId: String?, message: String?, replyChatId: String?, fileId: String?)
    {
        viewModelScope.launch(Dispatchers.IO) { AddTaskMessageUseCase(mainInterfaceImpl).execute(userId, taskId, listId, message, replyChatId, fileId) }
    }

    fun renameTaskMessage(id: String?, taskId: String?, listId: String?, message: String?)
    {
        viewModelScope.launch(Dispatchers.IO) { RenameTaskMessageUseCase(mainInterfaceImpl).execute(id, taskId, listId, message) }
    }

    fun deleteTaskMessage(id: String?, taskId: String?)
    {
        viewModelScope.launch(Dispatchers.IO) { DeleteTaskMessageUseCase(mainInterfaceImpl).execute(id, taskId) }
    }

    fun readTaskMessage(id: String?, taskId: String?, userId: String?, allRead: Boolean?)
    {
        viewModelScope.launch(Dispatchers.IO) { ReadTaskMessageUseCase(mainInterfaceImpl).execute(id, taskId, userId, allRead) }
    }

    fun startTypingTaskMessage()
    {}

    fun endTypingTaskMessage()
    {}

    fun getTaskMessage()
    {
        val taskChatSocketCallbackImpl = TaskChatSocketCallbackImpl(mainInterfaceImpl)
        GetTaskMessageUseCase(mainInterfaceImpl).execute(taskChatSocketCallbackImpl)
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
        getTask()
        getTaskMessage()
        getChat()
    }

    //UI methods
    //TODO Change
    fun setCurrentList(id: String?, name: String?)
    {
        currentListID = id
        currentListName = name
    }

    fun setCurrentTask(id: String?, name: String?)
    {
        currentTaskID = id
        currentTaskName = name
    }

    fun getCurrentListName(): String?{return currentListName}
    fun getCurrentListID(): String?{return currentListID}
}
