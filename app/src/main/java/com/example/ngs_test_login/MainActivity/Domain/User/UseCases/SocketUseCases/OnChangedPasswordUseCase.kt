package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserPasswordSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class OnChangedPasswordUseCase(private val userRepository: UserRepository)
{
    fun execute(userPasswordSocketCallbackInterface: UserPasswordSocketCallbackInterface)
    {
        userRepository.onChangedPassword(userPasswordSocketCallbackInterface)
    }
}