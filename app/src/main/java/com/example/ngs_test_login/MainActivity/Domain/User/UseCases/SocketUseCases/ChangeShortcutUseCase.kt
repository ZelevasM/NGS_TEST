package com.example.ngs_test_login.MainActivity.Domain.User.UseCases.SocketUseCases

import com.example.ngs_test_login.MainActivity.Data.User.Web.Models.ShortcutWeb
import com.example.ngs_test_login.MainActivity.Domain.User.Repositories.UserRepository

class ChangeShortcutUseCase(private val userRepository: UserRepository)
{
    fun execute(shortcutWebs: ArrayList<ShortcutWeb?>?)
    {
        userRepository.changeShortcut(shortcutWebs)
    }
}