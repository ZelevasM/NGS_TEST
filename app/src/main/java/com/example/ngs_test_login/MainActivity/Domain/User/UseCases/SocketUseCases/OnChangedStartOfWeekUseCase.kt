package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserStartOfWeekSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class OnChangedStartOfWeekUseCase(private val userInterface: UserInterface)
{
    fun execute(userStartOfWeekSocketCallbackInterface: UserStartOfWeekSocketCallbackInterface)
    {
        userInterface.onChangedStartOfWeek(userStartOfWeekSocketCallbackInterface)
    }
}