package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserEmailSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class OnChangedEmailUseCase(private val userRepository: UserRepository)
{
    fun execute(userEmailSocketCallbackInterface: UserEmailSocketCallbackInterface)
    {
        userRepository.onChangedEmail(userEmailSocketCallbackInterface)
    }
}