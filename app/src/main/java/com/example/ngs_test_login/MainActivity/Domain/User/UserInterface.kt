package com.example.ngs_test_login.MainActivity.Domain.User

import android.content.Context
import com.example.ngs_test_login.MainActivity.Domain.Models.User

interface UserInterface
{
    fun socketInit()

    fun localDbInit(context: Context)

    fun localDbClose()

    fun addLocalUser(context: Context,user: User?)

    fun getLocalUser(): User?

    fun changeName()

    //fun onChangedName()

    fun changeEmail()

    //fun onChangedEmail()

    fun changePassword()

    //fun onChangedPassword()

    fun changeHomepage()

    //fun onChangedHomepage()

    fun changeDateFormat()

    //fun onChangedDateFormat()

    fun changeTimeFormat()

    //fun onChangedTimeFormat()

    fun changeStartOfWeek()

    //fun onChangedStartOfWeek()

    fun changeExpandSubtask()

    //fun onChangedExpandSubtask()

    fun changeNewTask()

    //fun onChangedNewTask()
}