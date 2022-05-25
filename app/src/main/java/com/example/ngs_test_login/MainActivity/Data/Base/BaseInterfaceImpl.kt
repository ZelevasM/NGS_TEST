package com.example.ngs_test_login.MainActivity.Data.Base

import com.example.ngs_test_login.MainActivity.Data.Base.Web.BaseSocket
import com.example.ngs_test_login.MainActivity.Data.Main.Mappers.WebMainDataMapper
import com.example.ngs_test_login.MainActivity.Data.Base.Models.WebMainData
import com.example.ngs_test_login.MainActivity.Data.Base.Serializers.MainDataSerializer
import com.example.ngs_test_login.MainActivity.Data.Main.Web.GetData
import com.example.ngs_test_login.MainActivity.Domain.Base.BaseInterface
import com.example.ngs_test_login.MainActivity.Domain.Base.SocketCallbacks.BaseSocketCallback
import com.example.ngs_test_login.MainActivity.Domain.Models.MainData
import io.socket.client.Socket

class BaseInterfaceImpl: BaseInterface
{
    private lateinit var bSocket: Socket

    override fun socketInit(baseSocketCallback: BaseSocketCallback): Socket
    {
        bSocket = BaseSocket().initialize(baseSocketCallback)
        return bSocket
    }

    override fun getData(): MainData?
    {
        val getData = GetData()
        val dataJson: String? = getData.getData()
        val mainDataSerializer: MainDataSerializer = MainDataSerializer(dataJson)
        val webMainData: WebMainData? = mainDataSerializer.doSerialization()
        val webMainDataMapper: WebMainDataMapper = WebMainDataMapper()
        val mainData: MainData? = webMainDataMapper.fromWebData(webMainData)

        return mainData
    }
}