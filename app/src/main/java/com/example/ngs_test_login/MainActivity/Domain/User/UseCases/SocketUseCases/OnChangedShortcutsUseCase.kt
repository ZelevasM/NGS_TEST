package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserShortcutsSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class OnChangedShortcutsUseCase(private val userInterface: UserInterface)
{
    fun execute(userShortcutsSocketCallbackInterface: UserShortcutsSocketCallbackInterface)
    {
        userInterface.onChangedShortcut(userShortcutsSocketCallbackInterface)
    }
}