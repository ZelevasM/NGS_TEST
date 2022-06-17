package com.example.ngs_test_login.MainActivity.Data.User.Mappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.FolderWeb
import com.example.ngs_test_login.MainActivity.Data.User.Web.Models.ShortcutWeb
import com.example.ngs_test_login.MainActivity.Data.User.Web.Models.UserWeb
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Folder
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.User.Models.User

class UserMapper: DoubleMapper<User?, UserWeb?>
{
    override fun mapFromTToK(value: User?): UserWeb?
    {
        val shortcuts: ArrayList<ShortcutWeb?>? = ArrayList()
        if(value?.shortcuts != null)
        {
            for(i in value.shortcuts!!)
            shortcuts?.add(ShortcutMapper().mapFromTToK(i))
        }
        val folders: ArrayList<FolderWeb?>? = ArrayList()
        if(value?.folders != null)
        {
            for(i in value.folders!!)
            {
                folders?.add(FolderMapper().mapFromTToK(i))
            }
        }
        return UserWeb(id = value?.id, name = value?.name, email = value?.email, shortcutInbox = value?.shortcutInbox, language = value?.language,
        diskSpace = value?.diskSpace, showSidebar = value?.showSidebar, expandSubtask = value?.expandSubtask, newTask = value?.newTask,
        homepage = HomepageMapper().mapFromTToK(value?.homepage), dateFormatWeb = DateFormatMapper().mapFromTToK(value?.dateFormat),
        shortcutWebs = shortcuts, folderWeb = folders)
    }

    override fun mapFromKTOT(value: UserWeb?): User?
    {
        val shortcuts: ArrayList<Shortcut?>? = ArrayList()
        if(value?.shortcutWebs != null)
        {
            for(i in value.shortcutWebs!!)
                shortcuts?.add(ShortcutMapper().mapFromKTOT(i))
        }
        val folders: ArrayList<Folder?>? = ArrayList()
        if(value?.folderWeb != null)
        {
            for(i in value.folderWeb!!)
            {
                folders?.add(FolderMapper().mapFromKTOT(i))
            }
        }
        return User(id = value?.id, name = value?.name, email = value?.email, shortcutInbox = value?.shortcutInbox, language = value?.language,
            diskSpace = value?.diskSpace, showSidebar = value?.showSidebar, expandSubtask = value?.expandSubtask, newTask = value?.newTask,
            homepage = HomepageMapper().mapFromKTOT(value?.homepage), dateFormat = DateFormatMapper().mapFromKTOT(value?.dateFormatWeb),
            shortcuts = shortcuts, folders = folders)
    }
}