package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserHomepageSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class OnChangedHomepageUseCase(private val userInterface: UserInterface)
{
    fun execute(userHomepageSocketCallbackInterface: UserHomepageSocketCallbackInterface)
    {
        userInterface.onChangedHomepage(userHomepageSocketCallbackInterface)
    }
}