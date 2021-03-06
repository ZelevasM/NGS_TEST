package com.example.ngs_test_login.MainActivity.Data.Main

import android.content.Context
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.ChatsDao
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalChatsDb.ChatsDatabase
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.ListsDao
import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.ListsDatabase
import com.example.ngs_test_login.MainActivity.Domain.Main.Repositories.MainRepository
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ChatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.Chat
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.TaskChatCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.TaskSocketCallbackInterface
import io.socket.client.Socket

class MainRepositoryImpl: MainRepository
{
    /*
        Structure of the Class:
        1. Local Db Methods
            1. Lists
            2. Tasks
            3. Tasks' Chats
            4. Chats
        2. Socket Methods
            1. Lists
            2. Tasks
            3. Tasks' Chats
            4. Chats
     */
    //lateinit then + init fun
    private lateinit var mSocket: Socket

    //Local DB
    private var listsRepositoryImpl: ListsRepositoryImpl? = null
    private var tasksRepositoryImpl: TasksRepositoryImpl? = null
    private var tasksChatsRepositoryImpl: TasksChatsRepositoryImpl? = null
    private var chatRepositoryImpl: ChatRepositoryImpl? = null
    private var listsDao: ListsDao? = null
    private var chatsDao: ChatsDao? = null

    //Local Database's Methods

    override fun localDbInit(context: Context)
    {
        listsDao = ListsDatabase.getDatabase(context).listsDao()
        listsRepositoryImpl = ListsRepositoryImpl(listsDao!!)
        tasksRepositoryImpl = TasksRepositoryImpl(listsDao!!)
        tasksChatsRepositoryImpl = TasksChatsRepositoryImpl(listsDao!!)

        chatsDao = ChatsDatabase.getDatabase(context).chatsDao()
        chatRepositoryImpl = ChatRepositoryImpl(chatsDao!!)
    }

    override fun localDbClose()
    {
        ListsDatabase.closeDatabase()
        ChatsDatabase.closeDatabase()
    }

    //Local Database's Methods For Lists

    override fun addLocalLists(dataLists: ArrayList<DataList?>?)
    {
        listsRepositoryImpl?.addLocalLists(dataLists)
    }

    override fun getLocalLists(): ArrayList<DataList?>?
    {
        return listsRepositoryImpl?.getLocalLists()
    }

    override fun addLocalList(dataList: DataList?)
    {
        listsRepositoryImpl?.addLocalList(dataList)
    }

    override fun updateLocalList(dataList: DataList?)
    {
        listsRepositoryImpl?.updateLocalList(dataList)
    }

    override fun deleteLocalList(dataList: DataList?)
    {
        listsRepositoryImpl?.deleteLocalList(dataList)
    }

    override fun getLocalList(dataList: DataList?): DataList?
    {
        return listsRepositoryImpl?.getLocalList(dataList)
    }

    //Local Database's Methods For Tasks

    override fun searchTasks()
    {
        TODO("Not yet implemented")
    }

    override fun addLocalTask(task: Task?,listId: String?)
    {
        tasksRepositoryImpl?.addLocalTask(task, listId)
    }

    override fun doneLocalTask(task: Task?,listId: String?)
    {
        tasksRepositoryImpl?.doneLocalTask(task, listId)
    }

    override fun noteLocalTask(task: Task?,listId: String?)
    {
        tasksRepositoryImpl?.noteLocalTask(task, listId)
    }

    override fun renameLocalTask(task: Task?,listId: String?)
    {
        tasksRepositoryImpl?.renameLocalTask(task, listId)
    }

    override fun deleteLocalTask(task: Task?,listId: String?)
    {
        tasksRepositoryImpl?.deleteLocalTask(task, listId)
    }

    override fun getLocalTask(taskId: String?,listId: String?): Task?
    {
        return tasksRepositoryImpl?.getLocalTask(taskId, listId)
    }

    //Local Database's Methods For Tasks' Chats

    override fun addLocalTaskMessage(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {
        tasksChatsRepositoryImpl?.addLocalTaskMessage(taskMessage, taskId, listId)
    }

    override fun renameLocalTaskMessage(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {
        tasksChatsRepositoryImpl?.renameLocalTaskMessage(taskMessage, taskId, listId)
    }

    override fun deleteLocalTaskMessage(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {
        tasksChatsRepositoryImpl?.deleteLocalTaskMessage(taskMessage, taskId, listId)
    }

    override fun readLocalTaskMessage(taskMessage: TaskMessage?,taskId: String?,listId: String?)
    {
        tasksChatsRepositoryImpl?.readLocalTaskMessage(taskMessage, taskId, listId)
    }

    override fun getLocalTaskMessage(taskMessage: TaskMessage?,taskId: String?,listId: String?): TaskMessage?
    {
        return tasksChatsRepositoryImpl?.getLocalTaskMessage(taskMessage, taskId, listId)
    }

    //Local Database's Methods For Chats

    override fun addLocalChats(chats: ArrayList<Chat?>?)
    {
        chatRepositoryImpl?.addLocalChats(chats)
    }

    override fun getLocalChats(): ArrayList<Chat?>?
    {
        return chatRepositoryImpl?.getLocalChats()
    }

    override fun addLocalChat()
    {
        chatRepositoryImpl?.addLocalChat()
    }

    override fun updateLocalChat()
    {
        chatRepositoryImpl?.updateChat()
    }

    override fun deleteLocalChat()
    {
        chatRepositoryImpl?.deleteLocalChat()
    }

    override fun getLocalChat()
    {
        chatRepositoryImpl?.getLocalChat()
    }

    //Socket's Methods

    override fun socketInit(bSocket: Socket)
    {
        mSocket = bSocket
        listsRepositoryImpl?.socketInit(mSocket)
        tasksRepositoryImpl?.socketInit(mSocket)
        tasksChatsRepositoryImpl?.socketInit(mSocket)
        chatRepositoryImpl?.socketInit(mSocket)
    }

    //Socket's Methods For Lists

    override fun addList(name: String)
    {
        listsRepositoryImpl?.addList(name)
    }

    override fun updateList(id: String,newName: String)
    {
        listsRepositoryImpl?.updateList(id, newName)
    }

    override fun deleteList(id: String)
    {
        listsRepositoryImpl?.deleteList(id)
    }

    override fun getList(listSocketCallbackInterface: ListSocketCallbackInterface)
    {
        listsRepositoryImpl?.getList(listSocketCallbackInterface)
    }

    //Socket's Methods For Tasks

    override fun addTask(name: String, projectId: String, parentTaskId: String?)
    {
        tasksRepositoryImpl?.addTask(name, projectId, parentTaskId)
    }

    override fun doneTask(id: String,projectId: String,done: Boolean)
    {
        tasksRepositoryImpl?.doneTask(id, projectId, done)
    }

    override fun assignTask(id: String,projectId: String,userId: String?)
    {
        tasksRepositoryImpl?.assignTask(id, projectId, userId)
    }

    override fun remindTask(id: String,projectId: String,remind: String?)
    {
        tasksRepositoryImpl?.remindTask(id, projectId, remind)
    }

    override fun dateTask(id: String,projectId: String,date: String?)
    {
        tasksRepositoryImpl?.dateTask(id, projectId, date)
    }

    override fun noteTask(id: String, projectId: String, notes: String?)
    {
        tasksRepositoryImpl?.noteTask(id, projectId, notes)
    }

    override fun orderTask()
    {
        tasksRepositoryImpl?.orderTask()
    }

    override fun renameTask(id: String, newName: String?,  projectId: String)
    {
       tasksRepositoryImpl?.renameTask(id, newName, projectId)
    }

    override fun deleteTask(id: String,projectId: String)
    {
        tasksRepositoryImpl?.deleteTask(id, projectId)
    }

    override fun getTask(taskSocketCallbackInterface: TaskSocketCallbackInterface)
    {
        tasksRepositoryImpl?.getTask(taskSocketCallbackInterface)
    }

    //Socket's Methods for Tasks' Chats

    override fun addTaskMessage(userId: String?,taskId: String?,listId: String?,message: String?,replyChatId: String?,fileId: String?)
    {
        tasksChatsRepositoryImpl?.addTaskMessage(userId, taskId, listId, message, replyChatId, fileId)
    }

    override fun renameTaskMessage(id: String?,taskId: String?,listId: String?,message: String?)
    {
        tasksChatsRepositoryImpl?.renameTaskMessage(id, taskId, listId, message)
    }

    override fun deleteTaskMessage(id: String?,taskId: String?,listId: String?)
    {
        tasksChatsRepositoryImpl?.deleteTaskMessage(id, taskId, listId)
    }

    override fun readTaskMessage(id: String?,taskId: String?,userId: String?,allRead: Boolean?)
    {
        tasksChatsRepositoryImpl?.readTaskMessage(id, taskId, userId, allRead)
    }

    override fun startTypingTaskMessage()
    {
        tasksChatsRepositoryImpl?.startTypingTaskMessage()
    }

    override fun endTypingTaskMessage()
    {
        tasksChatsRepositoryImpl?.endTypingTaskMessage()
    }

    override fun getTaskMessage(taskChatCallbackInterface: TaskChatCallbackInterface)
    {
        tasksChatsRepositoryImpl?.getTaskMessage(taskChatCallbackInterface)
    }

    //Socket's Methods For Chats

    override fun addChat(name: String)
    {
        chatRepositoryImpl?.addChat(name)
    }

    override fun updateChat()
    {
        chatRepositoryImpl?.updateChat()
    }

    override fun deleteChat()
    {
        chatRepositoryImpl?.deleteChat()
    }

    override fun getChat(chatSocketCallbackInterface: ChatSocketCallbackInterface)
    {
        chatRepositoryImpl?.getChat(chatSocketCallbackInterface)
    }
}