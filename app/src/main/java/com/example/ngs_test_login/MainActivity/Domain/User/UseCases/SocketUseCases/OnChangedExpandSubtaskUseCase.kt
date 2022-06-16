package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.SocketCallbacks.UserSubtaskSocketCallbackInterface
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class OnChangedExpandSubtaskUseCase(private val userRepository: UserRepository)
{
    fun execute(userSubtaskSocketCallbackInterface: UserSubtaskSocketCallbackInterface)
    {
        userRepository.onChangedExpandSubtask(userSubtaskSocketCallbackInterface)
    }
}