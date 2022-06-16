package com.example.ngs_test_login.MainActivity.Domain.Base.Models

import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ChatsModel.Chat
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import com.example.ngs_test_login.MainActivity.Domain.User.Models.User


//TODO change to fields to private and remove data class
data class MainData(
    val dataLists: ArrayList<DataList?>?,

    val chats: ArrayList<Chat?>?,

    val user: User?)
{
}