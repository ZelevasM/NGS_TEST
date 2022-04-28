package com.example.ngs_test_login.MainActivity.Data.Main

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.ngs_test_login.BuildConfig
import com.example.ngs_test_login.MainActivity.Data.Main.Mappers.WebMainDataMapper
import com.example.ngs_test_login.MainActivity.Data.Main.Web.GetData
import com.example.ngs_test_login.MainActivity.Data.Main.Models.WebMainData
import com.example.ngs_test_login.MainActivity.Data.Main.Web.MainSocket
import com.example.ngs_test_login.MainActivity.Data.Main.Web.SocketList
import com.example.ngs_test_login.MainActivity.Domain.Main.MainInterface
import com.example.ngs_test_login.MainActivity.Domain.Models.MainData
import io.socket.client.Socket

class MainInterfaceImpl: MainInterface
{
    //lateinit then + init fun
    var mSocket: Socket = MainSocket().initialize()
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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun socketList()
    {
        //TODO STUBS - Delete

        val socketList: SocketList = SocketList(mSocket)
        socketList.getList()
        socketList.addList()

        socketList.addChat()
        socketList.getChat()
    }


}