package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class Shortcut(
    @field:SerializedName("color")
    val color: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("project_id")
    val projectId: String? = null)
{}