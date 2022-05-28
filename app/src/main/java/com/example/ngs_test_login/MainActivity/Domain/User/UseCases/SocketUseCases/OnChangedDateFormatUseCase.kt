package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserDateFormatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class OnChangedDateFormatUseCase(private val userInterface: UserInterface)
{
    fun execute(userDateFormatSocketCallbackInterface: UserDateFormatSocketCallbackInterface)
    {
        userInterface.onChangedDateFormat(userDateFormatSocketCallbackInterface)
    }
}