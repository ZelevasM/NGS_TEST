package com.example.ngs_test_login.MainActivity.Domain.Main.Mappers

interface MainDataMapper <WebMainData, MainData>
{
    fun fromWebData(webMainData: WebMainData): MainData
}