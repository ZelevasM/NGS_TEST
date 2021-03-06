package com.example.ngs_test_login.MainActivity.Data.User.Web

import android.util.Log
import com.example.ngs_test_login.MainActivity.Data.Base.Serializers.SocketDataSerializer
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ConvertClassToJson
import com.example.ngs_test_login.MainActivity.Data.User.Web.Models.SocketGeneralSetting
import com.example.ngs_test_login.MainActivity.Data.User.Web.Models.SocketOutMessage
import io.socket.client.Socket
import org.json.JSONObject

class UserGeneralSettingsSocket(private val mSocket: Socket)
{
    fun <T> onEmit (type: String, field: T)
    {
        val socketGeneralSetting: SocketGeneralSetting<T> = SocketGeneralSetting (type, field)
        val socketGeneralSettingJson: JSONObject = ConvertClassToJson(socketGeneralSetting).convert()
        val event: String = "IN_UserGeneralSettings"
        mSocket.emit(event, socketGeneralSettingJson)
    }

    fun onReceive(): String?
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
            Log.d("MyLog", "Serialized: $socketGeneralSetting")
            result = socketGeneralSetting.field
        }
        return result
    }
}