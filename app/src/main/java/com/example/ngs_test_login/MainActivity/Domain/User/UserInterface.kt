package com.example.ngs_test_login.MainActivity.Domain.User

import android.content.Context
import com.example.ngs_test_login.MainActivity.Domain.Models.Shortcut
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

    fun changeEmail(email: String?)

    fun onChangedEmail(userEmailSocketCallbackInterface: UserEmailSocketCallbackInterface)

    fun changePassword()

    fun onChangedPassword(userPassSocketCallbackInterface: UserPasswordSocketCallbackInterface)

    fun changeHomepage(homepage: String?)

    fun onChangedHomepage(userHomeSocketCallbackInterface: UserHomepageSocketCallbackInterface)

    fun changeDateFormat(dateFormat: String?)

    fun onChangedDateFormat(userDateFormatSocketCallbackInterface: UserDateFormatSocketCallbackInterface)

    fun changeTimeFormat(timeFormat: String?)

    fun onChangedTimeFormat(userTimeFormatSocketCallbackInterface: UserTimeFormatSocketCallbackInterface)

    fun changeStartOfWeek(startOfWeek: String?)

    fun onChangedStartOfWeek(userStartOfWeekSocketCallbackInterface: UserStartOfWeekSocketCallbackInterface)

    fun changeExpandSubtask(expandSubtask: String?)

    fun onChangedExpandSubtask(userSubtaskSocketCallbackInterface: UserSubtaskSocketCallbackInterface)

    fun changeNewTask(newTask: String?)

    fun onChangedNewTask(userNewTaskSocketCallbackInterface: UserNewTaskSocketCallbackInterface)

    fun changeShortcut(shortcuts: ArrayList<Shortcut?>?)

    fun onChangedShortcut(userShortcutsSocketCallbackInterface: UserShortcutsSocketCallbackInterface)
}