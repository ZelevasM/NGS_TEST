package com.example.ngs_test_login.MainActivity.Data.Main.Web

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.ngs_test_login.MainActivity.Data.Base.Serializers.SocketDataSerializer
import com.example.ngs_test_login.MainActivity.Data.Main.Models.SocketSendList
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList
import io.socket.client.Socket
import org.json.JSONObject


class ListSocket(private val mSocket: Socket)
{
    //TODO Bear all events out to consts
    @RequiresApi(Build.VERSION_CODES.O)
    fun addList(name: String)
    {
        val id: String = IdGenerator("6260f84e5db5e505faccecb2").generate()
        val order = 9
        val socketSendList: SocketSendList = SocketSendList(name, id, order)
        val socketList: JSONObject = ConvertClassToJson(socketSendList).convert()
        val event: String = "IN_ProjectAdd"
        mSocket.emit(event, socketList)
    }

    fun updateList(id: String, newName: String)
    {
        val socketSendList: SocketSendList = SocketSendList(name = newName, id = id)
        val socketList: JSONObject = ConvertClassToJson(socketSendList).convert()
        val event: String = "IN_ProjectRename"
        mSocket.emit(event, socketList)
    }

    fun deleteList(id: String)
    {
        val socketSendList: SocketSendList = SocketSendList(id = id)
        val socketList: JSONObject = ConvertClassToJson(socketSendList).convert()
        val event: String = "IN_ProjectDelete"
        mSocket.emit(event, socketList)
    }

    fun getList(listSocketCallbackInterface: ListSocketCallbackInterface)
    {
        var serializerSocket: SocketDataSerializer<DataList>
        val list: DataList = DataList()
        mSocket.on("OUT_Message")
        {
            Log.d("MyLog","OUT MESSAGE")
            Log.d("MyLog","ConnexionInList: ${mSocket.connected()}")
        }

        mSocket.on("OUT_ProjectAdd")
        {
            args->
                Log.d("MyLog","GOT LIST: ${args[0]}")
                serializerSocket = SocketDataSerializer(args[0] as JSONObject, list.javaClass)
                listSocketCallbackInterface.onAdded(serializerSocket.doSerialization())
        }

        mSocket.on("OUT_ProjectRename")
        {
                args->
            Log.d("MyLog","GOT LIST UPDATE: ${args[0]}")
            serializerSocket = SocketDataSerializer(args[0] as JSONObject, list.javaClass)
            listSocketCallbackInterface.onUpdated(serializerSocket.doSerialization())
        }

        mSocket.on("OUT_ProjectDelete")
        {
                args->
            Log.d("MyLog","GOT LIST DELETE: ${args[0]}")
            serializerSocket = SocketDataSerializer(args[0] as JSONObject, list.javaClass)
            listSocketCallbackInterface.onDeleted(serializerSocket.doSerialization())
        }

        //onUpdated
        //onDeleted
        //change methods inside of callbackInterfaceAccordingly
    }
}