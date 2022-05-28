package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserPasswordSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class OnChangedPasswordUseCase(private val userInterface: UserInterface)
{
    fun execute(userPasswordSocketCallbackInterface: UserPasswordSocketCallbackInterface)
    {
        userInterface.onChangedPassword(userPasswordSocketCallbackInterface)
    }
}