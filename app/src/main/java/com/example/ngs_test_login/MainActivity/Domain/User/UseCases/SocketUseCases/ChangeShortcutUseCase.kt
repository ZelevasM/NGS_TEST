package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Domain.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class ChangeShortcutUseCase(private val userInterface: UserInterface)
{
    fun execute(shortcuts: ArrayList<Shortcut?>?)
    {
        userInterface.changeShortcut(shortcuts)
    }
}