package com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Mappers

import com.example.ngs_test_login.MainActivity.Data.Main.Local.LocalListsDb.Entities.ListsEntity
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class ListsEntityMapper: DoubleMapper<DataList?, ListsEntity?>
{
    override fun mapFromTToK(value: DataList?): ListsEntity?
    {
        if(value?.id == null)
            throw Exception("No Id")
        return ListsEntity(id = value.id, name = value.name, author = value.author, date = value.date, color = value.color, V = value.V,
        order = value.order, orderBy = value.orderBy, users = value.users, sections = value.sections, tasks = value.tasks)
    }

    override fun mapFromKTOT(value: ListsEntity?): DataList?
    {
        return DataList(id = value?.id!!, name = value.name, author = value.author, date = value.date, color = value.color, V = value.V,
            order = value.order, orderBy = value.orderBy, users = value.users, sections = value.sections, tasks = value.tasks)
    }
}