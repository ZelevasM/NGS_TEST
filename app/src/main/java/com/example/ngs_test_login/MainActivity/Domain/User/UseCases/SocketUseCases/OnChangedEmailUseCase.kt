package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserEmailSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class OnChangedEmailUseCase(private val userInterface: UserInterface)
{
    fun execute(userEmailSocketCallbackInterface: UserEmailSocketCallbackInterface)
    {
        userInterface.onChangedEmail(userEmailSocketCallbackInterface)
    }
}