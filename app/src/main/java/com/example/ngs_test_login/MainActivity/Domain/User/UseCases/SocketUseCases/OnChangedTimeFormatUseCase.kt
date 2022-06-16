package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserTimeFormatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class OnChangedTimeFormatUseCase(private val userRepository: UserRepository)
{
    fun execute(userTimeFormatSocketCallbackInterface: UserTimeFormatSocketCallbackInterface)
    {
        userRepository.onChangedTimeFormat(userTimeFormatSocketCallbackInterface)
    }
}