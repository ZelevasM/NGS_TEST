package com.example.ngs_test_login.MainActivity.Domain.User

import android.content.Context
import com.example.ngs_test_login.MainActivity.Data.User.Models.ShortcutWeb
import com.example.ngs_test_login.MainActivity.Data.User.Models.UserWeb
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.*
import io.socket.client.Socket

interface UserInterface: UserLocalProviderInterface, DateFormatLocalProviderInterface
{
    fun socketInit(bSocket: Socket)

    fun localDbInit(context: Context)

    fun localDbClose()

    fun addLocalUser(userWeb: UserWeb?)

    fun getLocalUser(): UserWeb?

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

    fun changeShortcut(shortcutWebs: ArrayList<ShortcutWeb?>?)

    fun onChangedShortcut(userShortcutsSocketCallbackInterface: UserShortcutsSocketCallbackInterface)
}