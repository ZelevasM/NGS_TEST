package com.example.ngs_test_login.MainActivity.Domain.Main

import com.example.ngs_test_login.MainActivity.Domain.Models.MainData

interface MainInterface
{
    fun getData(): MainData

    fun socketList()
}