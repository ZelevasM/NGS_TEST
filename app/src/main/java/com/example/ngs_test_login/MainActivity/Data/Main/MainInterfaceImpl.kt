package com.example.ngs_test_login.MainActivity.Data.Main

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.ngs_test_login.MainActivity.Data.Main.Local.UserDatabaseManager
import com.example.ngs_test_login.MainActivity.Data.Main.Mappers.WebMainDataMapper
import com.example.ngs_test_login.MainActivity.Data.Main.Web.GetData
import com.example.ngs_test_login.MainActivity.Data.Main.Models.WebMainData
import com.example.ngs_test_login.MainActivity.Data.Main.Web.MainSocket
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatSocket
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListSocket
import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ChatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.MainData
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import io.socket.client.Socket

class MainInterfaceImpl: MainInterface
{
    //lateinit then + init fun
    private lateinit var mSocket: Socket
    private lateinit var listSocket: ListSocket
    private lateinit var chatSocket: ChatSocket

    //Local DB
    private var userDatabaseManager: UserDatabaseManager? = null


    override fun getData(): MainData
    {
        val getData = GetData()
        val dataJson = getData.getData()
        val mainDataSerializer: MainDataSerializer = MainDataSerializer(dataJson)
        val webMainData: WebMainData = mainDataSerializer.doSerialization()
        val webMainDataMapper: WebMainDataMapper = WebMainDataMapper()
        val mainData: MainData = webMainDataMapper.fromWebData(webMainData)

        return mainData
    }

    override fun socketInit()
    {
        mSocket = MainSocket().initialize()
        listSocket = ListSocket(mSocket)
        chatSocket = ChatSocket(mSocket)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun addList(name: String)
    {
        listSocket.addList(name)
    }

    override fun getList(listSocketCallbackInterface: ListSocketCallbackInterface)
    {
        listSocket.getList(listSocketCallbackInterface)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun addChat(name: String)
    {
        chatSocket.addChat(name)
    }

    override fun getChat(chatSocketCallbackInterface: ChatSocketCallbackInterface)
    {
        chatSocket.getChat(chatSocketCallbackInterface)
    }

    override fun localDbInit(context: Context): Boolean?
    {
        //userDatabaseManager = UserDatabaseManager.getInstance(context)
        userDatabaseManager = UserDatabaseManager(context)
        val newlyCreated: Boolean? = userDatabaseManager?.openDb()
        return newlyCreated
    }

    override fun localDbClose()
    {
        userDatabaseManager?.closeDb()
    }

    override fun addLocalUser(context: Context, user: User?)
    {
        //test db
        userDatabaseManager?.writeToDb(user)
    }

    override fun getLocalUser(): User?
    {
        val user: User? = userDatabaseManager?.readFromDb()
        return user
    }
}