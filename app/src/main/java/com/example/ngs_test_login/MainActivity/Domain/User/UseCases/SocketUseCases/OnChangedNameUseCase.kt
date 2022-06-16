package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserNameSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class OnChangedNameUseCase(private val userRepository: UserRepository)
{
    fun execute(userNameSocketCallbackInterface: UserNameSocketCallbackInterface)
    {
        userRepository.onChangedName(userNameSocketCallbackInterface)
    }
}