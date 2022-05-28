package com.example.ngs_test_login.MainActivity.Domain.Models

import com.google.gson.annotations.SerializedName

data class DateFormat(
    @field:SerializedName("date") var date: String? = null,

    @field:SerializedName("start_of_the_week") var startOfTheWeek: String? = null,

    @field:SerializedName("time") var time: String? = null)
{}