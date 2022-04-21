package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class DateFormat(
    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("start_of_the_week")
    val startOfTheWeek: String? = null,

    @field:SerializedName("time")
    val time: String? = null)
{}