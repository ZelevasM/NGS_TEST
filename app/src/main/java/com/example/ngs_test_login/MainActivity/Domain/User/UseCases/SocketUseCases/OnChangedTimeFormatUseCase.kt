package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserTimeFormatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class OnChangedTimeFormatUseCase(private val userInterface: UserInterface)
{
    fun execute(userTimeFormatSocketCallbackInterface: UserTimeFormatSocketCallbackInterface)
    {
        userInterface.onChangedTimeFormat(userTimeFormatSocketCallbackInterface)
    }
}