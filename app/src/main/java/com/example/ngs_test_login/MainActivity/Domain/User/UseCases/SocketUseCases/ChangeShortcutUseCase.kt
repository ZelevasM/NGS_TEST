package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class ChangeShortcutUseCase(private val userRepository: UserRepository)
{
    fun execute(shortcuts: ArrayList<Shortcut?>?)
    {
        userRepository.changeShortcut(shortcuts)
    }
}