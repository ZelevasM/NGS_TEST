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
interface UserRepository: UserInfoRepository, GeneralSettingsRepository, DateFormatRepository, ShortcutsRepository
{
    fun localDbInit(context: Context)

    fun localDbClose()

    fun addLocalUser(user: User?)

    fun getLocalUser(): User?

    //Socket's Methods

    fun socketInit(bSocket: Socket)

}