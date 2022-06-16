package com.example.ngs_test_login.MainActivity.Data.User.Mappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.FolderWeb
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Folder
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class FolderMapper: DoubleMapper<Folder?, FolderWeb?>
{
    override fun mapFromTToK(value: Folder?): FolderWeb?
    {
        return FolderWeb(lists = value?.lists, id = value?.id, name = value?.name, order = value?.order)
    }

    override fun mapFromKTOT(value: FolderWeb?): Folder?
    {
        return Folder(lists = value?.lists, id = value?.id, name = value?.name, order = value?.order)
    }

}