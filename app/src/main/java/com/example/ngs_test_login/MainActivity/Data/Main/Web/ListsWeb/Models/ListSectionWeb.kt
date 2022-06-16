package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models

import com.google.gson.annotations.SerializedName

data class ListSectionWeb(
    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("order")
    val order: Int? = null)
{}