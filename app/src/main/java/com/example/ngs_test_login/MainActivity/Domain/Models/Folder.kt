package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class Folder(
    @field:SerializedName("lists" )
    var lists: ArrayList<String?>? = ArrayList(),
    @field:SerializedName("_id" )
    var id: String? = null,
    @field:SerializedName("name" )
    var name: String? = null,
    @field:SerializedName("order" )
    var order: String? = null,)
{}