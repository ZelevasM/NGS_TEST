package com.example.ngs_test_login.MainActivity.Data.Base.Models

import com.example.ngs_test_login.MainActivity.Domain.Models.Chat
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.google.gson.annotations.SerializedName

data class WebMainData(
    @field:SerializedName("lists")
    val dataLists: ArrayList<DataList?>?,

    @field:SerializedName("chats")
    val chats: ArrayList<Chat?>?,

    @field:SerializedName("user")
    val user: User?)
{}