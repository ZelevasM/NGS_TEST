package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class Folder(
    @field:SerializedName("lists" )
    val lists: List<String?>? = null,
    @field:SerializedName("_id" )
    val id: String? = null,
    @field:SerializedName("name" )
    val name: String? = null,
    @field:SerializedName("order" )
    val order: String? = null,)
{}