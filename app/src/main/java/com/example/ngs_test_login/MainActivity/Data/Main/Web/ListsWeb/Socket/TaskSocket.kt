package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Socket

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.ngs_test_login.MainActivity.Data.Base.Serializers.SocketDataSerializer
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ConvertClassToJson
import com.example.ngs_test_login.MainActivity.Data.Main.Web.IdGenerator
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.SocketSendList
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksSocketModels.SocketSendTaskSecondWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksSocketModels.SocketSendTaskWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.SocketCallbacks.ListSocketCallbackInterface
import io.socket.client.Socket
import org.json.JSONObject

class TaskSocket(private val mSocket: Socket)
{
    //TODO Bear all events out to consts
    @RequiresApi(Build.VERSION_CODES.O)
    fun addTask(name: String, projectId: String, parentTaskId: String?)
    {
        val id: String = IdGenerator("6260f84e5db5e505faccecb2").generate()
        val socketSendTaskWeb = SocketSendTaskWeb(id = id, name, projectId, parentTaskId, assign = null)
        val socketTask: JSONObject = ConvertClassToJson(socketSendTaskWeb).convert()
        val event: String = "IN_TaskAdd"
        mSocket.emit(event, socketTask)
    }

    fun doneTask(id: String, projectId: String, done: Boolean)
    {
        val socketSendTaskWeb = SocketSendTaskWeb(id = id, projectId = projectId, done = done)
        val socketTask: JSONObject = ConvertClassToJson(socketSendTaskWeb).convert()
        val event: String = "IN_TaskDone"
        mSocket.emit(event, socketTask)
    }

    fun noteTask(id: String, projectId: String, notes: String?)
    {
        val socketSendTaskSecondWeb = SocketSendTaskSecondWeb(task_id = id, projectId = projectId, notes = notes)
        val socketTask: JSONObject = ConvertClassToJson(socketSendTaskSecondWeb).convert()
        val event: String = "IN_TaskNote"
        mSocket.emit(event, socketTask)
    }

    fun orderTask(newOrder: String, projectId: String)
    {
        val out: Boolean = true
        val socketSendTaskSecondWeb = SocketSendTaskSecondWeb(projectId = projectId, newOrder = newOrder, out = out)
        val socketTask: JSONObject = ConvertClassToJson(socketSendTaskSecondWeb).convert()
        val event: String = "IN_TaskOrder"
        mSocket.emit(event, socketTask)
    }

    fun renameTask(id: String, newName: String?,  projectId: String)
    {
        val socketSendTaskSecondWeb = SocketSendTaskSecondWeb(task_id = id, projectId = projectId, name = newName)
        val socketTask: JSONObject = ConvertClassToJson(socketSendTaskSecondWeb).convert()
        val event: String = "IN_TaskRename"
        mSocket.emit(event, socketTask)
    }

    fun deleteTask(id: String, projectId: String)
    {
        val socketSendTaskSecondWeb = SocketSendTaskSecondWeb(task_id = id, projectId = projectId)
        val socketTask: JSONObject = ConvertClassToJson(socketSendTaskSecondWeb).convert()
        val event: String = "IN_TaskDelete"
        mSocket.emit(event, socketTask)
    }

    fun getTask()
    {
        var serializerSocket: SocketDataSerializer<TaskWeb>
        val taskWeb: TaskWeb = TaskWeb()
        mSocket.on("OUT_Message")
        {
            Log.d("MyLog","OUT MESSAGE")
            Log.d("MyLog","ConnexionInList: ${mSocket.connected()}")
        }

        mSocket.on("OUT_TaskAdd")
        {
                args->
            Log.d("MyLog","GOT TASK: ${args[0]}")

        }

        mSocket.on("OUT_TaskDone")
        {
                args->
            Log.d("MyLog","GOT TASK: ${args[0]}")
        }

        mSocket.on("OUT_TaskNote")
        {
                args->
            Log.d("MyLog","GOT TASK: ${args[0]}")
        }

        mSocket.on("OUT_TaskOrder")
        {
                args->
            Log.d("MyLog","GOT TASK: ${args[0]}")
        }

        mSocket.on("OUT_TaskRename")
        {
                args->
            Log.d("MyLog","GOT TASK: ${args[0]}")
        }

        mSocket.on("OUT_TaskDelete")
        {
                args->
            Log.d("MyLog","GOT TASK: ${args[0]}")
        }
    }
}