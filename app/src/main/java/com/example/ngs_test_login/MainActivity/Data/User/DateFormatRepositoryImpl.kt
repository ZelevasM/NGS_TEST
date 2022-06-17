package com.example.ngs_test_login.MainActivity.Data.User

import com.example.ngs_test_login.MainActivity.Data.User.Local.UserDao
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.DateFormatRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserDateFormatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserStartOfWeekSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserTimeFormatSocketCallbackInterface

class DateFormatRepositoryImpl(private val userDao: UserDao): DateFormatRepository
{
    override fun saveLocalDateFormat(dateFormat: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalDateFormat(): String?
    {
        TODO("Not yet implemented")
    }

    override fun saveLocalTimeFormat(timeFormat: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalTimeFormat(): String?
    {
        TODO("Not yet implemented")
    }

    override fun saveLocalStartOfWeek(startOfWeek: String?)
    {
        TODO("Not yet implemented")
    }

    override fun getLocalStartOfWeek(): String?
    {
        TODO("Not yet implemented")
    }

    //Socket's Methods

    override fun changeDateFormat(dateFormat: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedDateFormat(userDateFormatSocketCallbackInterface: UserDateFormatSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }

    override fun changeTimeFormat(timeFormat: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedTimeFormat(userTimeFormatSocketCallbackInterface: UserTimeFormatSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }

    override fun changeStartOfWeek(startOfWeek: String?)
    {
        TODO("Not yet implemented")
    }

    override fun onChangedStartOfWeek(userStartOfWeekSocketCallbackInterface: UserStartOfWeekSocketCallbackInterface)
    {
        TODO("Not yet implemented")
    }
}