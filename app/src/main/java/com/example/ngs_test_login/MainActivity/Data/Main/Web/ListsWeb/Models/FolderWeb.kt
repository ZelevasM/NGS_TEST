package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models

import com.google.gson.annotations.SerializedName

data class FolderWeb(
    @field:SerializedName("lists" )
    var lists: ArrayList<String?>? = ArrayList(),
    @field:SerializedName("_id" )
    var id: String? = null,
    @field:SerializedName("name" )
    var name: String? = null,
    @field:SerializedName("order" )
    var order: String? = null)
{}