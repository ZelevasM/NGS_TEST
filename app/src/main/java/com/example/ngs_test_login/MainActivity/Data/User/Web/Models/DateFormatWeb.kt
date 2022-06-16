package com.example.ngs_test_login.MainActivity.Data.User.Web.Models

import com.google.gson.annotations.SerializedName

data class DateFormatWeb(
    @field:SerializedName("date") var date: String? = null,

    @field:SerializedName("start_of_the_week") var startOfTheWeek: String? = null,

    @field:SerializedName("time") var time: String? = null)
{}