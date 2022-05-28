package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserNameSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class OnChangedNameUseCase(private val userInterface: UserInterface)
{
    fun execute(userNameSocketCallbackInterface: UserNameSocketCallbackInterface)
    {
        userInterface.onChangedName(userNameSocketCallbackInterface)
    }
}