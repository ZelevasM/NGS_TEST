package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Socket

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.ngs_test_login.MainActivity.Data.Base.Serializers.SocketDataSerializer
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ConvertClassToJson
import com.example.ngs_test_login.MainActivity.Data.Main.Web.IdGenerator
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers.TasksChatsSocketMappers.SocketTaskMessageMapper
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers.TasksChatsSocketMappers.SocketTaskMessageSecondMapper
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers.TasksSocketMappers.SocketReceiveTaskMapper
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers.TasksSocketMappers.SocketReceiveTaskSecondMapper
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksChatsSocketModels.SocketTaskMessageSecondWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksChatsSocketModels.SocketTaskMessageWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksSocketModels.SocketReceiveTaskSecondWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksSocketModels.SocketReceiveTaskWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksSocketModels.SocketSendTaskSecondWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksSocketModels.SocketSendTaskWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.TaskChatCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.TaskSocketCallbackInterface
import io.socket.client.Socket
import org.json.JSONObject

class TaskChatSocket(private val mSocket: Socket)
{
    //TODO Bear all events out to consts
    @RequiresApi(Build.VERSION_CODES.O)
    fun addTaskMessage(userId: String?,taskId: String?,listId: String?,message: String?,replyChatId: String?,fileId: String?)
    {
        val id: String = IdGenerator("62a1a832c7c8e80568614d36").generate()
        val socketTaskMessageWeb = SocketTaskMessageWeb(id = id, userId = userId, taskId = taskId, projectId = listId, message = message,
                                                        replyChatId = replyChatId, fileId = fileId)
        val socketTaskMessage: JSONObject = ConvertClassToJson(socketTaskMessageWeb).convert()
        val event: String = "IN_CommitAdd"
        mSocket.emit(event, socketTaskMessage)
    }

    fun renameTaskMessage(id: String?,taskId: String?,listId: String?,message: String?)
    {
        val socketTaskMessageSecondWeb = SocketTaskMessageSecondWeb(id = id, taskId = taskId, projectId = listId, message = message)

        val socketTaskMessageSecond: JSONObject = ConvertClassToJson(socketTaskMessageSecondWeb).convert()
        val event: String = "IN_CommitRename"
        mSocket.emit(event, socketTaskMessageSecond)
    }

    fun deleteTaskMessage(id: String?,taskId: String?, listId: String?)
    {
        val socketTaskMessageSecondWeb = SocketTaskMessageSecondWeb(id = id, taskId = taskId, projectId = listId)

        val socketTaskMessageSecond: JSONObject = ConvertClassToJson(socketTaskMessageSecondWeb).convert()
        val event: String = "IN_CommitDelete"
        mSocket.emit(event, socketTaskMessageSecond)
    }

    fun readTaskMessage(id: String?,taskId: String?,userId: String?,allRead: Boolean?)
    {
        val socketTaskMessageSecondWeb = SocketTaskMessageSecondWeb(id = id, taskId = taskId, userId = userId, allRead = allRead)

        val socketTaskMessageSecond: JSONObject = ConvertClassToJson(socketTaskMessageSecondWeb).convert()
        val event: String = "IN_CommitReadMessage"
        mSocket.emit(event, socketTaskMessageSecond)
    }

    fun startTypingMessage()
    {

    }

    fun endTypingMessage()
    {

    }

    fun getTaskMessage(taskChatCallbackInterface: TaskChatCallbackInterface)
    {
        var serializerSocket: SocketDataSerializer<SocketTaskMessageWeb>
        var serializerSocketSecond: SocketDataSerializer<SocketTaskMessageSecondWeb>
        val socketTaskMessageWeb = SocketTaskMessageWeb()
        val socketTaskMessageSecondWeb = SocketTaskMessageSecondWeb()
        mSocket.on("OUT_Message")
        {
            Log.d("MyLog","OUT MESSAGE")
            Log.d("MyLog","ConnexionInTasksChat: ${mSocket.connected()}")
        }

        mSocket.on("OUT_CommitAdd")
        {
                args->
            Log.d("MyLog","GOT TASK MESSAGE in Added: ${args[0]}")
            serializerSocket = SocketDataSerializer(args[0] as JSONObject, socketTaskMessageWeb.javaClass)
            val taskMessage: TaskMessage? = SocketTaskMessageMapper().mapFromKTOT(serializerSocket.doSerialization().chat)
            val listId = serializerSocket.doSerialization().projectId
            val taskId = serializerSocket.doSerialization().chat?.taskId
            taskChatCallbackInterface.onMessageAdded(taskMessage, taskId = taskId, listId = listId)
        }

        mSocket.on("OUT_CommitRename")
        {
                args->
            Log.d("MyLog","GOT TASK MESSAGE in Renamed: ${args[0]}")
            serializerSocketSecond = SocketDataSerializer(args[0] as JSONObject, socketTaskMessageSecondWeb.javaClass)
            val taskMessage: TaskMessage? = SocketTaskMessageSecondMapper().mapFromKTOT(serializerSocketSecond.doSerialization())
            val listId = serializerSocketSecond.doSerialization().projectId
            val taskId = serializerSocketSecond.doSerialization().taskId
            taskChatCallbackInterface.onMessageRenamed(taskMessage, taskId = taskId, listId = listId)
        }

        mSocket.on("OUT_CommitDelete")
        {
                args->
            Log.d("MyLog","GOT TASK MESSAGE in Deleted: ${args[0]}")
            serializerSocketSecond = SocketDataSerializer(args[0] as JSONObject, socketTaskMessageSecondWeb.javaClass)
            val taskMessage: TaskMessage? = SocketTaskMessageSecondMapper().mapFromKTOT(serializerSocketSecond.doSerialization())
            val listId = serializerSocketSecond.doSerialization().projectId
            val taskId = serializerSocketSecond.doSerialization().taskId
            Log.d("MyLog","MESSAGE: ${taskMessage} \n TASK ID: $taskId, \n LIST ID: $listId")
            taskChatCallbackInterface.onMessageDeleted(taskMessage, taskId = taskId, listId = listId)
        }

        mSocket.on("OUT_CommitReadMessage")
        {
                args->
            Log.d("MyLog","GOT TASK MESSAGE in Read Message: ${args[0]}")
            serializerSocketSecond = SocketDataSerializer(args[0] as JSONObject, socketTaskMessageSecondWeb.javaClass)
            var taskMessage: TaskMessage? = SocketTaskMessageSecondMapper().mapFromKTOT(serializerSocketSecond.doSerialization())
            taskMessage?.read = true
            val listId = serializerSocketSecond.doSerialization().projectId
            val taskId = serializerSocketSecond.doSerialization().taskId
            taskChatCallbackInterface.onMessageRead(taskMessage, taskId, listId)
        }

        mSocket.on("OUT_CommitStartTyping")
        {
                args->
            Log.d("MyLog","GOT TASK MESSAGE in Start Typing:${args[0]}")

        }

        mSocket.on("OUT_CommitEndTyping")
        {
                args->
            Log.d("MyLog","GOT TASK MESSAGE in End Typing: ${args[0]}")

        }
    }
}