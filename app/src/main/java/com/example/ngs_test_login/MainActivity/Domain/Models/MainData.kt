package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

//TODO change to fields to private and remove data class
data class MainData(
     val dataLists: ArrayList<DataList?>?,

     val chats: ArrayList<Chat?>?,

     val user: User?)
{
}