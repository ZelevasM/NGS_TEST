package com.example.ngs_test_login.MainActivity.Data.User

import com.example.ngs_test_login.MainActivity.Data.User.Local.UserDao
import com.example.ngs_test_login.MainActivity.Data.User.Web.UserSocket
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.DateFormatRepository
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserDateFormatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserStartOfWeekSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserTimeFormatSocketCallbackInterface
import io.socket.client.Socket

class DateFormatRepositoryImpl(private val userDao: UserDao): DateFormatRepository
{
    private lateinit var userSocket: UserSocket
    override fun saveLocalDateFormat(dateFormat: String?)
    {
        userDao.updateDateFormat(dateFormat)
    }

    override fun getLocalDateFormat(): String?
    {
        return userDao.getDateFormat()
    }

    override fun saveLocalTimeFormat(timeFormat: String?)
    {
        userDao.updateTimeFormat(timeFormat)
    }

    override fun getLocalTimeFormat(): String?
    {
        return userDao.getTimeFormat()
    }

    override fun saveLocalStartOfWeek(startOfWeek: String?)
    {
        userDao.updateStartOfWeek(startOfWeek)
    }

    override fun getLocalStartOfWeek(): String?
    {
        return userDao.getStartOfWeek()
    }

    override fun socketInit(bSocket: Socket)
    {
        userSocket = UserSocket(bSocket)
    }

    //Socket's Methods

    override fun changeDateFormat(dateFormat: String?)
    {
        userSocket.changeDateFormat(dateFormat)
    }

    override fun onChangedDateFormat(userDateFormatSocketCallbackInterface: UserDateFormatSocketCallbackInterface)
    {
        userSocket.onChangedDateFormat(userDateFormatSocketCallbackInterface)
    }

    override fun changeTimeFormat(timeFormat: String?)
    {
        userSocket.changeTimeFormat(timeFormat)
    }

    override fun onChangedTimeFormat(userTimeFormatSocketCallbackInterface: UserTimeFormatSocketCallbackInterface)
    {
        userSocket.onChangedTimeFormat(userTimeFormatSocketCallbackInterface)
    }

    override fun changeStartOfWeek(startOfWeek: String?)
    {
        userSocket.changeStartOfWeek(startOfWeek)
    }

    override fun onChangedStartOfWeek(userStartOfWeekSocketCallbackInterface: UserStartOfWeekSocketCallbackInterface)
    {
        userSocket.onChangedStartOfWeek(userStartOfWeekSocketCallbackInterface)
    }
}