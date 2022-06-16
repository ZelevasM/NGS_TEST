package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Data.User.Models.ShortcutWeb
import com.example.ngs_test_login.MainActivity.Domain.User.UserInterface

class ChangeShortcutUseCase(private val userInterface: UserInterface)
{
    fun execute(shortcutWebs: ArrayList<ShortcutWeb?>?)
    {
        userInterface.changeShortcut(shortcutWebs)
    }
}