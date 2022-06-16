package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserDateFormatSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class OnChangedDateFormatUseCase(private val userRepository: UserRepository)
{
    fun execute(userDateFormatSocketCallbackInterface: UserDateFormatSocketCallbackInterface)
    {
        userRepository.onChangedDateFormat(userDateFormatSocketCallbackInterface)
    }
}