package com.example.ngs_test_login.MainActivity.Data.Base.Models

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ChatsWeb.Models.ChatWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.DataListWeb
import com.example.ngs_test_login.MainActivity.Data.User.Models.UserWeb
import com.google.gson.annotations.SerializedName

data class WebMainData(
    @field:SerializedName("lists")
    val dataListWebs: ArrayList<DataListWeb?>?,

    @field:SerializedName("chats")
    val chatWebs: ArrayList<ChatWeb?>?,

    @field:SerializedName("user")
    val userWeb: UserWeb?)
{}