package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserHomepageSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class OnChangedHomepageUseCase(private val userRepository: UserRepository)
{
    fun execute(userHomepageSocketCallbackInterface: UserHomepageSocketCallbackInterface)
    {
        userRepository.onChangedHomepage(userHomepageSocketCallbackInterface)
    }
}