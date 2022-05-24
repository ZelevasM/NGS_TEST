package com.example.ngs_test_login.MainActivity.Presentation

import android.content.Context

interface ViewModelInterface
{
    fun socketInit()

    fun localDbInit(context: Context)

    fun localDbClose()
}