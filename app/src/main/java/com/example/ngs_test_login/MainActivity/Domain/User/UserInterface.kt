package com.example.ngs_test_login.MainActivity.Domain.User

import android.content.Context
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.*
import io.socket.client.Socket

interface UserInterface: UserLocalProviderInterface, DateFormatLocalProviderInterface
{
    fun socketInit(bSocket: Socket)

    fun localDbInit(context: Context)

    fun localDbClose()

    fun addLocalUser(user: User?)

    fun getLocalUser(): User?

    fun changeName(name: String?)

    fun onChangedName(userNameSocketCallbackInterface: UserNameSocketCallbackInterface)

    fun changeEmail()

    fun onChangedEmail(userEmailSocketCallbackInterface: UserEmailSocketCallbackInterface)

    fun changePassword()

    fun onChangedPassword(userPassSocketCallbackInterface: UserPasswordSocketCallbackInterface)

    fun changeHomepage(homepage: String?)

    fun onChangedHomepage(userHomeSocketCallbackInterface: UserHomepageSocketCallbackInterface)

    fun changeDateFormat()

    fun onChangedDateFormat(userDateFormatSocketCallbackInterface: UserDateFormatSocketCallbackInterface)

    fun changeTimeFormat()

    fun onChangedTimeFormat(userTimeFormatSocketCallbackInterface: UserTimeFormatSocketCallbackInterface)

    fun changeStartOfWeek()

    fun onChangedStartOfWeek(userStartOfWeekSocketCallbackInterface: UserStartOfWeekSocketCallbackInterface)

    fun changeExpandSubtask()

    fun onChangedExpandSubtask(userSubtaskSocketCallbackInterface: UserSubtaskSocketCallbackInterface)

    fun changeNewTask()

    fun onChangedNewTask(userNewTaskSocketCallbackInterface: UserNewTaskSocketCallbackInterface)
}