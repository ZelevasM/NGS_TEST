package com.example.ngs_test_login.MainActivity.Domain.User.Repositories

import com.example.ngs_test_login.MainActivity.Domain.User.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserDateFormatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserStartOfWeekSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserTimeFormatSocketCallbackInterface

interface DateFormatRepository
{
    fun saveLocalDateFormat(dateFormat: String?)

    fun getLocalDateFormat(): String?

    fun saveLocalTimeFormat(timeFormat: String?)

    fun getLocalTimeFormat(): String?

    fun saveLocalStartOfWeek(startOfWeek: String?)

    fun getLocalStartOfWeek(): String?

    //Socket's Methods

    fun changeDateFormat(dateFormat: String?)

    fun onChangedDateFormat(userDateFormatSocketCallbackInterface: UserDateFormatSocketCallbackInterface)


    fun changeTimeFormat(timeFormat: String?)

    fun onChangedTimeFormat(userTimeFormatSocketCallbackInterface: UserTimeFormatSocketCallbackInterface)


    fun changeStartOfWeek(startOfWeek: String?)

    fun onChangedStartOfWeek(userStartOfWeekSocketCallbackInterface: UserStartOfWeekSocketCallbackInterface)
}