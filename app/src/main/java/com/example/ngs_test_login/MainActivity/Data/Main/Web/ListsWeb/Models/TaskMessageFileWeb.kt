package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models

import com.google.gson.annotations.SerializedName

data class TaskMessageFileWeb(
    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("size")
    val size: Int? = null,

    @field:SerializedName("filename")
    val filename: String? = null,

    @field:SerializedName("imgHeight")
    val imgHeight: Int? = null,

    @field:SerializedName("imgWidth")
    val imgWidth: Int? = null,

    @field:SerializedName("ext")
    val extension: String? = null,

    @field:SerializedName("date")
    val date: String? = null)
{}