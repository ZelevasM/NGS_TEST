package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserShortcutsSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class OnChangedShortcutsUseCase(private val userRepository: UserRepository)
{
    fun execute(userShortcutsSocketCallbackInterface: UserShortcutsSocketCallbackInterface)
    {
        userRepository.onChangedShortcut(userShortcutsSocketCallbackInterface)
    }
}