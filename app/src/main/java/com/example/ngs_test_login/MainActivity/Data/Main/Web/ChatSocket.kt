package com.example.ngs_test_login.MainActivity.Data.Main.Web

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.ngs_test_login.MainActivity.Data.Main.Models.SocketSendChat
import com.example.ngs_test_login.MainActivity.Data.Base.Serializers.SocketDataSerializer
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ChatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.Chat
import io.socket.client.Socket
import org.json.JSONObject

class ChatSocket(private val mSocket: Socket)
{
    @RequiresApi(Build.VERSION_CODES.O)
    fun addChat(name: String)
    {
        Log.d("MyLog","CHAT SOCKET START:")

        val id: String = IdGenerator("6260f84e5db5e505faccecb2").generate()

        //TODO replace by json in emit
        val socketSendChat: SocketSendChat = SocketSendChat(name, id)
        val socketChat: JSONObject = ConvertClassToJson(socketSendChat).convert()
        Log.d("MyLog","hat: ${socketChat.toString()}")
        mSocket.emit("IN_AddChats", id, name)
    }

    fun getChat(chatSocketCallbackInterface: ChatSocketCallbackInterface)
    {
        var socketDataSerializer: SocketDataSerializer<Chat>
        var chat: Chat = Chat()
        mSocket.on("OUT_Message")
        {
            Log.d("MyLog","OUT MESSAGE")
            Log.d("MyLog","ConnexionInChat: ${mSocket.connected()}")
        }

        mSocket.on("OUT_AddChats")
        {
             args->
                Log.d("MyLog","GOT CHAT: ${args[0]} ")
                socketDataSerializer = SocketDataSerializer(args[0] as JSONObject, chat.javaClass)
                chatSocketCallbackInterface.onChanged(socketDataSerializer.doSerialization())
        }
    }
}