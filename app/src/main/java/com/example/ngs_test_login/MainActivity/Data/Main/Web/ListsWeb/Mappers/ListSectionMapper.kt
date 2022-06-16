package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.ListSectionWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.ListSection
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class ListSectionMapper: DoubleMapper<ListSection?, ListSectionWeb?>
{
    override fun mapFromTToK(value: ListSection?): ListSectionWeb?
    {
        return ListSectionWeb(name = value?.name, id = value?.id, order = value?.order)
    }

    override fun mapFromKTOT(value: ListSectionWeb?): ListSection?
    {
        return ListSection(name = value?.name, id = value?.id, order = value?.order)
    }
}