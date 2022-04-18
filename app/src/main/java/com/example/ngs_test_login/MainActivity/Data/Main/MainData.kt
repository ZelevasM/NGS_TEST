package com.example.ngs_test_login.MainActivity.Data.Main

import com.example.ngs_test_login.MainActivity.Domain.Models.Chat
import com.example.ngs_test_login.MainActivity.Domain.Models.List
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.google.gson.annotations.SerializedName

class MainData(private val lists: ArrayList<List>, private val chats: ArrayList<Chat>,
               private val user: ArrayList<User>)
{
    @SerializedName("lists")
    val mLists: ArrayList<List> = lists
    @SerializedName("chats")
    val mChats: ArrayList<Chat> = chats
    @SerializedName("user")
    val mUser: ArrayList<User> = user
}