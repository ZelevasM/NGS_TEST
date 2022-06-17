package com.example.ngs_test_login.MainActivity.Data.Base.Mappers

import com.example.ngs_test_login.MainActivity.Data.Base.Models.WebMainData
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatsWeb.Mappers.ChatMapper
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers.DataListMapper
import com.example.ngs_test_login.MainActivity.Data.User.Web.Mappers.UserMapper
import com.example.ngs_test_login.MainActivity.Domain.Mappers.Mapper
import com.example.ngs_test_login.MainActivity.Domain.Base.Models.MainData
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.Chat
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList

class WebMapper: Mapper<WebMainData?, MainData?>
{
    override fun map(webMainData: WebMainData?): MainData?
    {
        return putData(webMainData)
    }

    private fun putData(webMainData: WebMainData?): MainData?
    {
        var mainData: MainData? = null
        if(webMainData != null)
        {
            val dataLists: ArrayList<DataList?>? = ArrayList()
            val chats: ArrayList<Chat?>? = ArrayList()
            if(webMainData?.dataListWebs != null)
            {
                for(i in webMainData.dataListWebs)
                {
                    dataLists?.add(DataListMapper().mapFromKTOT(i))
                }
            }
            if(webMainData?.chatWebs != null)
            {
                for(i in webMainData.chatWebs)
                {
                    chats?.add(ChatMapper().mapFromKTOT(i))
                }
            }

            mainData = MainData(
                dataLists = dataLists,
                chats = chats,
                user = UserMapper().mapFromKTOT(webMainData.userWeb))
        }
        return mainData
    }
}