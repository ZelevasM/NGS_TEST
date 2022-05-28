package com.example.ngs_test_login.MainActivity.Data.User.Web

import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Base.Serializers.SocketDataSerializer
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ConvertClassToJson
import com.example.ngs_test_login.MainActivity.Data.User.Models.*
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.*
import io.socket.client.Socket
import org.json.JSONObject

class UserSocket(private val mSocket: Socket)
{
    fun changeName(name: String?)
    {
        val type: String = "change_name"

        val socketName: SocketName = SocketName(type, name)
        val socketNameJson: JSONObject = ConvertClassToJson(socketName).convert()
        val event: String = "IN_UserEdit"
        mSocket.emit(event, socketNameJson)
    }

    fun onChangedName(userNameSocketCallbackInterface: UserNameSocketCallbackInterface)
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
                userNameSocketCallbackInterface.onChanged(name = name.name)
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

    fun onChangedEmail(userEmailSocketCallbackInterface: UserEmailSocketCallbackInterface)
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
            userEmailSocketCallbackInterface.onChanged(email = email.email)
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

    fun onChangedPassword(userPassSocketCallbackInterface: UserPasswordSocketCallbackInterface)
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
            userPassSocketCallbackInterface.onChanged(newPassword.message.toString())
            Log.d("MyLog", "Serialized: $newPassword")
        }
    }

    fun changeLanguage()
    {}

    fun changeHomepage(homepage: String?)
    {
        val type: String =  "homepage"
        val fieldType: String? = homepage
        val fieldId: String? = null

        val field: SocketHomepageField = SocketHomepageField(fieldType, fieldId)
        val socketHomepage: SocketHomepage = SocketHomepage(type, field)
        val socketGeneralSettingJson: JSONObject = ConvertClassToJson(socketHomepage).convert()
        val event: String = "IN_UserGeneralSettings"
        mSocket.emit(event, socketGeneralSettingJson)
    }

    fun onChangedHomepage(userHomeSocketCallbackInterface: UserHomepageSocketCallbackInterface)
    {
//        var socketDataSerializer: SocketDataSerializer<SocketHomepage>
//        var socketHomepage: SocketHomepage = SocketHomepage()
//        val event: String = "OUT_UserGeneralSettings"
//
//        var outMessage: SocketOutMessage = SocketOutMessage()
//        var socketDataSerializerOut: SocketDataSerializer<SocketOutMessage>
//        mSocket.on("OUT_Message")
//        { args ->
//            socketDataSerializerOut = SocketDataSerializer(args[0] as JSONObject, outMessage.javaClass)
//            outMessage = socketDataSerializerOut.doSerialization()
//            Log.d("MyLog","OUT MESSAGE")
//            Log.d("MyLog","ConnexionInHomepage: ${mSocket.connected()}")
//        }
//        mSocket.on(event)
//        { args ->
//            Log.d("MyLog","GOT HOMEPAGE MESSAGE: ${args[0]}")
//            val generalSetting: SocketGeneralSetting = args[0]
//            socketDataSerializer = SocketDataSerializer(args[0] as JSONObject, SocketGeneralSetting)
//            socketHomepage = socketDataSerializer.doSerialization()
//            userHomeSocketCallbackInterface.onChanged(socketHomepage.field?.type)
//            Log.d("MyLog", "Serialized: ${socketHomepage.field?.type}")
//        }
    }

    fun changeDateFormat()
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        val type: String =  "date_format"
        val field: String = "MM/DD/YYYY"
        userGeneralSettingsSocket.onEmit(type, field)
    }

    fun onChangedDateFormat(userDateFormatSocketCallbackInterface: UserDateFormatSocketCallbackInterface)
    {
        var socketDataSerializer: SocketDataSerializer<SocketGeneralSetting<String>>
        var socketGeneralSetting: SocketGeneralSetting<String> = SocketGeneralSetting()
        val event: String = "OUT_UserGeneralSettings"
        var result: String? = null

        var outMessage: SocketOutMessage = SocketOutMessage()
        var socketDataSerializerOut: SocketDataSerializer<SocketOutMessage>
        mSocket.on("OUT_Message")
        { args ->
            socketDataSerializerOut = SocketDataSerializer(args[0] as JSONObject, outMessage.javaClass)
            outMessage = socketDataSerializerOut.doSerialization()
            Log.d("MyLog","OUT MESSAGE")
            Log.d("MyLog","ConnexionInDateFormat: ${mSocket.connected()}")
            result = "Error"
        }
        mSocket.on(event)
        { args ->
            Log.d("MyLog","GOT ${args[0].toString()} MESSAGE: ${args[0]}")
            socketDataSerializer = SocketDataSerializer(args[0] as JSONObject, socketGeneralSetting.javaClass)
            socketGeneralSetting = socketDataSerializer.doSerialization()
            when(socketGeneralSetting.type)
            {
                "date_format" -> userDateFormatSocketCallbackInterface.onChanged(socketGeneralSetting.field)
            }
            Log.d("MyLog", "Serialized: ${socketGeneralSetting.field}")
            //result = socketGeneralSetting.field
        }

    }

    fun changeTimeFormat()
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        val type: String =  "date_format"
        val field: String = ""
        userGeneralSettingsSocket.onEmit(type, field)
    }

    fun onChangedTimeFormat(userTimeFormatSocketCallbackInterface: UserTimeFormatSocketCallbackInterface)
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        userTimeFormatSocketCallbackInterface.onChanged(userGeneralSettingsSocket.onReceive())
    }

    fun changeStartOfWeek()
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        val type: String =  "date_format"
        val field: String = ""
        userGeneralSettingsSocket.onEmit(type, field)
    }

    fun onChangedStartOfWeek(userStartOfWeekSocketCallbackInterface: UserStartOfWeekSocketCallbackInterface)
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        userStartOfWeekSocketCallbackInterface.onChanged(userGeneralSettingsSocket.onReceive())
    }

    fun changeExpandSubtask()
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        val type: String =  "date_format"
        val field: Boolean = false
        userGeneralSettingsSocket.onEmit(type, field)
    }

    fun onChangedExpandSubtask(userSubtaskSocketCallbackInterface: UserSubtaskSocketCallbackInterface)
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        userSubtaskSocketCallbackInterface.onChanged(userGeneralSettingsSocket.onReceive())
    }

    fun changeNewTask()
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        val type: String =  "date_format"
        val field: Boolean = false
        userGeneralSettingsSocket.onEmit(type, field)
    }

    fun onChangedNewTask(userNewTaskSocketCallbackInterface: UserNewTaskSocketCallbackInterface)
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        userNewTaskSocketCallbackInterface.onChanged(userGeneralSettingsSocket.onReceive())
    }
}