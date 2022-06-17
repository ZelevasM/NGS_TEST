package com.example.ngs_test_login.MainActivity.Data.User.Web

import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Base.Serializers.SocketDataSerializer
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ConvertClassToJson
import com.example.ngs_test_login.MainActivity.Data.User.Web.Mappers.ShortcutMapper
import com.example.ngs_test_login.MainActivity.Data.User.Web.Models.*
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut
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

    fun changeEmail(email: String?)
    {
        val type: String = "change_email"
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
            socketDataSerializer = SocketDataSerializer(args[0] as JSONObject, socketGeneralSetting.javaClass)
            socketGeneralSetting = socketDataSerializer.doSerialization()
            if(socketGeneralSetting.type == "homepage")
            {
                userHomeSocketCallbackInterface.onChanged(socketGeneralSetting.field)
                Log.d("MyLog","GOT ${args[0].toString()} MESSAGE: ${args[0]}")
                Log.d("MyLog", "Serialized: ${socketGeneralSetting.field}")
            }
            //result = socketGeneralSetting.field
        }
    }

    fun changeDateFormat(field: String?)
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        val type: String =  "date_format"
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
            socketDataSerializer = SocketDataSerializer(args[0] as JSONObject, socketGeneralSetting.javaClass)
            socketGeneralSetting = socketDataSerializer.doSerialization()
            if(socketGeneralSetting.type == "date_format")
            {
                userDateFormatSocketCallbackInterface.onChanged(socketGeneralSetting.field)
                Log.d("MyLog","GOT ${args[0].toString()} MESSAGE: ${args[0]}")
                Log.d("MyLog", "Serialized: ${socketGeneralSetting.field}")
            }
            //result = socketGeneralSetting.field
        }
    }

    fun changeTimeFormat(field: String?)
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        val type: String =  "time_format"
        userGeneralSettingsSocket.onEmit(type, field)
    }

    fun onChangedTimeFormat(userTimeFormatSocketCallbackInterface: UserTimeFormatSocketCallbackInterface)
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
            socketDataSerializer = SocketDataSerializer(args[0] as JSONObject, socketGeneralSetting.javaClass)
            socketGeneralSetting = socketDataSerializer.doSerialization()
            if(socketGeneralSetting.type == "time_format")
            {
                userTimeFormatSocketCallbackInterface.onChanged(socketGeneralSetting.field)
                Log.d("MyLog","GOT ${args[0].toString()} MESSAGE: ${args[0]}")
                Log.d("MyLog", "Serialized: ${socketGeneralSetting.field}")
            }
            //result = socketGeneralSetting.field
        }
    }

    fun changeStartOfWeek(field: String?)
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        val type: String =  "start_of_the_week"
        userGeneralSettingsSocket.onEmit(type, field)
    }

    fun onChangedStartOfWeek(userStartOfWeekSocketCallbackInterface: UserStartOfWeekSocketCallbackInterface)
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
            socketDataSerializer = SocketDataSerializer(args[0] as JSONObject, socketGeneralSetting.javaClass)
            socketGeneralSetting = socketDataSerializer.doSerialization()
            if(socketGeneralSetting.type == "start_of_the_week")
            {
                userStartOfWeekSocketCallbackInterface.onChanged(socketGeneralSetting.field)
                Log.d("MyLog","GOT ${args[0].toString()} MESSAGE: ${args[0]}")
                Log.d("MyLog", "Serialized: ${socketGeneralSetting.field}")
            }
            //result = socketGeneralSetting.field
        }
    }

    fun changeExpandSubtask(subtask: String?)
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        val type: String =  "expand_subtask"
        var field: Boolean = false
        if(subtask == "Enabled")
            field = true
        else
            field = false
        userGeneralSettingsSocket.onEmit(type, field)
    }

    fun onChangedExpandSubtask(userSubtaskSocketCallbackInterface: UserSubtaskSocketCallbackInterface)
    {
        var socketDataSerializer: SocketDataSerializer<SocketGeneralSetting<Boolean>>
        var socketGeneralSetting: SocketGeneralSetting<Boolean> = SocketGeneralSetting()
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
            socketDataSerializer = SocketDataSerializer(args[0] as JSONObject, socketGeneralSetting.javaClass)
            socketGeneralSetting = socketDataSerializer.doSerialization()
            val field: String?
            if(socketGeneralSetting.type == "expand_subtask")
            {
                val checker: Boolean? = socketGeneralSetting.field
                if(checker == true)
                    field = "Enabled"
                else
                    field = "Disabled"
                Log.d("MyLog","$field")
                userSubtaskSocketCallbackInterface.onChanged(field)
                Log.d("MyLog","GOT ${args[0].toString()} MESSAGE: ${args[0]}")
                Log.d("MyLog", "Serialized: ${socketGeneralSetting.field}")
            }
            //result = socketGeneralSetting.field
        }
    }

    fun changeNewTask(newTask: String?)
    {
        val userGeneralSettingsSocket: UserGeneralSettingsSocket = UserGeneralSettingsSocket(mSocket)
        val type: String =  "new_task"
        var field: Boolean = false
        if(newTask == "Top")
            field = true
        else
            field = false
        userGeneralSettingsSocket.onEmit(type, field)
    }

    fun onChangedNewTask(userNewTaskSocketCallbackInterface: UserNewTaskSocketCallbackInterface)
    {
        var socketDataSerializer: SocketDataSerializer<SocketGeneralSetting<Boolean>>
        var socketGeneralSetting: SocketGeneralSetting<Boolean> = SocketGeneralSetting()
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
            socketDataSerializer = SocketDataSerializer(args[0] as JSONObject, socketGeneralSetting.javaClass)
            socketGeneralSetting = socketDataSerializer.doSerialization()
            val field: String?
            if(socketGeneralSetting.type == "new_task")
            {
                val checker: Boolean? = socketGeneralSetting.field
                if(checker == true)
                    field = "Top"
                else
                    field = "Bottom"

                Log.d("MyLog","$field")
                userNewTaskSocketCallbackInterface.onChanged(field)
                Log.d("MyLog","GOT ${args[0].toString()} MESSAGE: ${args[0]}")
                Log.d("MyLog", "Serialized: ${socketGeneralSetting.field}")
            }
            //result = socketGeneralSetting.field
        }
    }

    fun changeShortcut(shortcuts: ArrayList<Shortcut?>?)
    {
        //val socketShortcuts: Array<Shortcut?>? = SocketShortcut(type)
        val socketShortcutJson: ArrayList<JSONObject?> = ArrayList()
        if(shortcuts !=null)
        {
            for (i in shortcuts.indices)
            {
                socketShortcutJson.add(ConvertClassToJson(ShortcutMapper().mapFromTToK(shortcuts[i])).convert())
            }
        }
        Log.d("MyLog","Short Type is Json Object: ${socketShortcutJson is ArrayList<JSONObject?>?}")
        //val socketShortcutsJsonArray: Array<*>? = socketShortcutJson.toArray() as Array<*>?

        val event: String = "IN_Shortcuts"
        mSocket.emit(event, socketShortcutJson)
        Log.d("MyLog","SHORTS: $socketShortcutJson")
    }

    fun onChangedShortcut(userShortcutsSocketCallbackInterface: UserShortcutsSocketCallbackInterface)
    {
        var socketDataSerializer: SocketDataSerializer<SocketShortcuts>
        var socketDataSerializerOut: SocketDataSerializer<SocketOutMessage>
        var shortcuts: SocketShortcuts = SocketShortcuts()
        var outMessage: SocketOutMessage = SocketOutMessage()
        val event: String = "OUT_Shortcuts"
        mSocket.on("OUT_Message")
        {
                args ->
            socketDataSerializerOut = SocketDataSerializer(args[0] as JSONObject, outMessage.javaClass)
            outMessage = socketDataSerializerOut.doSerialization()
            Log.d("MyLog","OUT MESSAGE: $outMessage")
            Log.d("MyLog","ConnexionInShortcuts: ${mSocket.connected()}")
        }
        mSocket.on(event)
        {
                args ->
            Log.d("MyLog","GOT SHORTCUTS: ${args[0]}")
            socketDataSerializer = SocketDataSerializer(args[0] as JSONObject, shortcuts.javaClass)
            shortcuts = socketDataSerializer.doSerialization()
            val shorts = ArrayList<Shortcut?>()
            for(i in shortcuts.shortcutWebs.indices)
            {
                shorts?.add(ShortcutMapper().mapFromKTOT(shortcuts.shortcutWebs[i]))
            }
            userShortcutsSocketCallbackInterface.onChanged(shortcuts  = shorts)
            Log.d("MyLog", "Serialized: $shortcuts")
        }
    }
}