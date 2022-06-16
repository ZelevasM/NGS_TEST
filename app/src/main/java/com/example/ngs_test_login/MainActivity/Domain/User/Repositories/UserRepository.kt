package com.example.ngs_test_login.MainActivity.Domain.User.Repositories

import android.content.Context
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.User.Models.User
import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.*
import io.socket.client.Socket

/*
These Repositories: Main and User, inherit each own corresponding repositories, but each of them has only 1 implementation: MainRepImpl and UserRepImpl.
Subsequently, in the future it provides more flexibility and allows creation of impl class for each parent repository of Main and User Reps.
 */
interface UserRepository: UserLocalProviderRepository,DateFormatRepository
{
    fun localDbInit(context: Context)

    fun localDbClose()

    fun addLocalUser(user: User?)

    fun getLocalUser(): User?

    //Socket's Methods

    fun socketInit(bSocket: Socket)


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