package com.example.ngs_test_login.MainActivity.Data.User.Web

import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Base.SocketDataSerializer
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ConvertClassToJson
import com.example.ngs_test_login.MainActivity.Data.User.Models.*
import io.socket.client.Socket
import org.json.JSONObject

class UserSocket(private val mSocket: Socket)
{
    fun changeName()
    {
        val type: String = "change_name"
        val name: String = "ENZIO"

        val socketName: SocketName = SocketName(type, name)
        val socketNameJson: JSONObject = ConvertClassToJson(socketName).convert()
        val event: String = "IN_UserEdit"
        mSocket.emit(event, socketNameJson)
    }

    fun onChangedName()
    {
        var socketDataSerializer: SocketDataSerializer<SocketName>
        var name: SocketName = SocketName()
        val event: String = "OUT_ChangeNameUser"
        mSocket.on("OUT_Message")
        {
            Log.d("MyLog","OUT MESSAGE")
            Log.d("MyLog","ConnexionInName: ${mSocket.connected()}")
        }
        mSocket.on(event)
        { args->
                Log.d("MyLog","GOT NAME: ${args[0]}")
                socketDataSerializer = SocketDataSerializer(args[0] as JSONObject, name.javaClass)
                name = socketDataSerializer.doSerialization()
                Log.d("MyLog", "Serialized: $name")
        }
    }

    fun changeEmail()
    {
        val type: String = "change_email"
        val email: String = "bmw@gmail.com"
        val password: String = "1234"

        val socketEmail: SocketEmail = SocketEmail(type, email, password)
        val socketEmailJson: JSONObject = ConvertClassToJson(socketEmail).convert()
        val event: String = "IN_UserEdit"
        mSocket.emit(event, socketEmailJson)
    }

    fun onChangedEmail()
    {
        var socketDataSerializer: SocketDataSerializer<SocketEmail>
        var socketDataSerializerOut: SocketDataSerializer<SocketOutMessage>
        var email: SocketEmail = SocketEmail()
        var outMessage: SocketOutMessage = SocketOutMessage()
        val event: String = "OUT_ChangeEmailUser"
        mSocket.on("OUT_Message")
        {
            args ->
            socketDataSerializerOut = SocketDataSerializer(args[0] as JSONObject, outMessage.javaClass)
            outMessage = socketDataSerializerOut.doSerialization()
            Log.d("MyLog","OUT MESSAGE: $outMessage")
            Log.d("MyLog","ConnexionInEmail: ${mSocket.connected()}")
        }
        mSocket.on(event)
        {
            args ->
            Log.d("MyLog","GOT EMAIL: ${args[0]}")
            socketDataSerializer = SocketDataSerializer(args[0] as JSONObject, email.javaClass)
            email = socketDataSerializer.doSerialization()
            Log.d("MyLog", "Serialized: $email")
        }
    }

    fun changePassword()
    {
        val type: String = "change_password"
        val newPassword: String = "1234"
        val oldPassword: String = "1"

        val socketPassword: SocketPassword = SocketPassword(type, newPassword, oldPassword)
        val socketPasswordJson: JSONObject = ConvertClassToJson(socketPassword).convert()
        val event: String = "IN_UserEdit"
        mSocket.emit(event, socketPasswordJson)
    }

    fun onChangedPassword()
    {
        var socketDataSerializer: SocketDataSerializer<SocketPasswordMessage>
        var newPassword: SocketPasswordMessage = SocketPasswordMessage()
        val event: String = "OUT_ChangePasswordUser"

        var outMessage: SocketOutMessage = SocketOutMessage()
        var socketDataSerializerOut: SocketDataSerializer<SocketOutMessage>
        mSocket.on("OUT_Message")
        { args ->
            socketDataSerializerOut = SocketDataSerializer(args[0] as JSONObject, outMessage.javaClass)
            outMessage = socketDataSerializerOut.doSerialization()
            Log.d("MyLog","OUT MESSAGE")
            Log.d("MyLog","ConnexionInPassword: ${mSocket.connected()}")
        }
        mSocket.on(event)
        { args ->
            Log.d("MyLog","GOT PASSWORD MESSAGE: ${args[0]}")
            socketDataSerializer = SocketDataSerializer(args[0] as JSONObject, newPassword.javaClass)
            newPassword = socketDataSerializer.doSerialization()
            Log.d("MyLog", "Serialized: $newPassword")
        }
    }

    fun changeLanguage()
    {}

    fun changeHomepage()
    {
        val type: String =  "homepage"
        val fieldType: String = "medium_priority"
        val fieldId: String? = null

        val field: SocketHomepageField = SocketHomepageField(fieldType, fieldId)
        val socketHomepage: SocketHomepage = SocketHomepage(type, field)
        val socketGeneralSettingJson: JSONObject = ConvertClassToJson(socketHomepage).convert()
        val event: String = "IN_UserGeneralSettings"
        mSocket.emit(event, socketGeneralSettingJson)
    }

    fun onChangedHomepage()
    {
        var socketDataSerializer: SocketDataSerializer<SocketHomepage>
        var socketHomepage: SocketHomepage = SocketHomepage()
        val event: String = "OUT_UserGeneralSettings"

        var outMessage: SocketOutMessage = SocketOutMessage()
        var socketDataSerializerOut: SocketDataSerializer<SocketOutMessage>
        mSocket.on("OUT_Message")
        { args ->
            socketDataSerializerOut = SocketDataSerializer(args[0] as JSONObject, outMessage.javaClass)
            outMessage = socketDataSerializerOut.doSerialization()
            Log.d("MyLog","OUT MESSAGE")
            Log.d("MyLog","ConnexionInHomepage: ${mSocket.connected()}")
        }
        mSocket.on(event)
        { args ->
            Log.d("MyLog","GOT HOMEPAGE MESSAGE: ${args[0]}")
            socketDataSerializer = SocketDataSerializer(args[0] as JSONObject, socketHomepage.javaClass)
            socketHomepage = socketDataSerializer.doSerialization()
            Log.d("MyLog", "Serialized: $socketHomepage")
        }
    }

    fun changeDateFormat()
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        val type: String =  "date_format"
        val field: String = "MM/DD/YYYY"
        userGeneralSettingsSocket.onEmit(type, field)
    }

    fun onChangedDateFormat()
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        userGeneralSettingsSocket.onReceive()
    }

    fun changeTimeFormat()
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        val type: String =  "date_format"
        val field: String = ""
        userGeneralSettingsSocket.onEmit(type, field)
    }

    fun onChangedTimeFormat()
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        userGeneralSettingsSocket.onReceive()
    }

    fun changeStartOfWeek()
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        val type: String =  "date_format"
        val field: String = ""
        userGeneralSettingsSocket.onEmit(type, field)
    }

    fun onChangedStartOfWeek()
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        userGeneralSettingsSocket.onReceive()
    }

    fun changeExpandSubtask()
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        val type: String =  "date_format"
        val field: Boolean = false
        userGeneralSettingsSocket.onEmit(type, field)
    }

    fun onChangedExpandSubtask()
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        userGeneralSettingsSocket.onReceive()
    }

    fun changeNewTask()
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        val type: String =  "date_format"
        val field: Boolean = false
        userGeneralSettingsSocket.onEmit(type, field)
    }

    fun onChangedNewTask()
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        userGeneralSettingsSocket.onReceive()
    }
}