package com.example.ngs_test_login.MainActivity.Data.Main

import com.example.ngs_test_login.MainActivity.Domain.Models.DataList
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.google.gson.annotations.SerializedName

data class MainData(
    @field:SerializedName("lists")
    private val dataLists: ArrayList<DataList?>?,

    @field:SerializedName("chats")
    private val chats: ArrayList<Any?>?,

    @field:SerializedName("user")
    private val user: User?)
{
}