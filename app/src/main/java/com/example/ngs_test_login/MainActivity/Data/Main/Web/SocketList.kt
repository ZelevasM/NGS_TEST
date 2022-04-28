package com.example.ngs_test_login.MainActivity.Data.Main.Web

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.ngs_test_login.MainActivity.Data.Main.Models.SocketSendChat
import com.example.ngs_test_login.MainActivity.Data.Main.Models.SocketSendList
import io.socket.client.Socket
import org.json.JSONObject


class SocketList(private val mSocket: Socket)
{
    //TODO Bear all events out to consts
    @RequiresApi(Build.VERSION_CODES.O)
    fun addList()
    {
        Log.d("MyLog","SOCKET_INPUT11:")
        //val options = IO.Options.builder().setExtraHeaders(mapOf("Authorization" to listOf(BuildConfig.Token))).build()
        Log.d("MyLog","Connexion: ${mSocket.connected()}")

        val name = "List#59"
        val id: String = IdGenerator("6260f84e5db5e505faccecb2").generate()
        val order = 16

        val socketSendList: SocketSendList = SocketSendList(name, id, order)
        val socketList: JSONObject = ConvertClassToJson(socketSendList).convert()
        mSocket.emit("IN_ProjectAdd", socketList)
    }

    fun getList()
    {
        mSocket.on("OUT_Message")
        {
            Log.d("MyLog","OUT MESSAGE")
            Log.d("MyLog","ConnexionInList: ${mSocket.connected()}")
        }

        mSocket.on("OUT_ProjectAdd")
        {
            Log.d("MyLog","GOT LIST ${Thread.currentThread().name}")
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addChat()
    {
        Log.d("MyLog","CHAT SOCKET START:")
        val name = "Chat7"
        val id: String = IdGenerator("6260f84e5db5e505faccecb2").generate()

        //TODO replace by json in emit
        val socketSendChat: SocketSendChat = SocketSendChat(name, id)
        val socketChat: JSONObject = ConvertClassToJson(socketSendChat).convert()
        Log.d("MyLog","hat: ${socketChat.toString()}")
        mSocket.emit("IN_AddChats", id, name)
    }

    fun getChat()
    {
        mSocket.on("OUT_Message")
        {
            Log.d("MyLog","OUT MESSAGE")
            Log.d("MyLog","ConnexionInChat: ${mSocket.connected()}")
        }

        mSocket.on("OUT_AddChats")
        {
            Log.d("MyLog","GOT CHAT")
        }
    }
}