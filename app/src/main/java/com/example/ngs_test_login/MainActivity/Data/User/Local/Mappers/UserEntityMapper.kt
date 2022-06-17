package com.example.ngs_test_login.MainActivity.Data.User.Local.Mappers

import com.example.ngs_test_login.MainActivity.Data.User.Local.Entities.UserEntity
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper
import com.example.ngs_test_login.MainActivity.Domain.User.Models.User

class UserEntityMapper: DoubleMapper<User?, UserEntity?>
{
    override fun mapFromTToK(value: User?): UserEntity?
    {
        if(value?.id == null)
            throw Exception("No Id")
        return UserEntity(id = value.id!!, name = value?.name, email = value?.email, shortcutInbox = value?.shortcutInbox, language = value?.language,
        diskSpace = value?.diskSpace, showSidebar = value?.showSidebar, expandSubtask = value?.expandSubtask, newTask = value?.expandSubtask,
            dateFormat = value?.dateFormat, homepage = value?.homepage, shortcuts = value?.shortcuts, folders = value?.folders)
    }

    override fun mapFromKTOT(value: UserEntity?): User?
    {
        return User(id = value?.id, name = value?.name, email = value?.email, shortcutInbox = value?.shortcutInbox, language = value?.language,
            diskSpace = value?.diskSpace, showSidebar = value?.showSidebar, expandSubtask = value?.expandSubtask, newTask = value?.expandSubtask,
            dateFormat = value?.dateFormat, homepage = value?.homepage, shortcuts = value?.shortcuts, folders = value?.folders)
    }
}