package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class TaskMessageFile(
    @field:SerializedName("_id")
    val userId: String? = null,

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