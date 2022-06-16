package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserStartOfWeekSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class OnChangedStartOfWeekUseCase(private val userRepository: UserRepository)
{
    fun execute(userStartOfWeekSocketCallbackInterface: UserStartOfWeekSocketCallbackInterface)
    {
        userRepository.onChangedStartOfWeek(userStartOfWeekSocketCallbackInterface)
    }
}