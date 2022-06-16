package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.DataListWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.ListSectionWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskUserWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.ListSection
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskUser
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class DataListMapper: DoubleMapper<DataList?, DataListWeb?>
{
    override fun mapFromTToK(value: DataList?): DataListWeb?
    {
        val users: ArrayList<TaskUserWeb?>? = ArrayList()
        if(value?.users != null)
        {
            for(i in value.users!!)
            {
                users?.add(TaskUserMapper().mapFromTToK(i))
            }
        }
        val sections: ArrayList<ListSectionWeb?>? = ArrayList()
        if(value?.sections != null)
        {
            for(i in value.sections!!)
            {
                sections?.add(ListSectionMapper().mapFromTToK(i))
            }
        }
        val tasks: ArrayList<TaskWeb?>? = ArrayList()
        if(value?.tasks != null)
        {
            for(i in value.tasks!!)
            {
                tasks?.add(TaskMapper().mapFromTToK(i))
            }
        }
        return DataListWeb(id = value?.id, name = value?.id, date = value?.date, author = value?.author, color = value?.color, V = value?.V,
        orderBy = value?.orderBy, order = value?.order, users = users, sections = sections, tasks = tasks)
    }

    override fun mapFromKTOT(value: DataListWeb?): DataList?
    {
        if(value?.id == null)
            throw Exception("No Id")
        val users: ArrayList<TaskUser?>? = ArrayList()
        if(value?.users != null)
        {
            for(i in value.users!!)
            {
                users?.add(TaskUserMapper().mapFromKTOT(i))
            }
        }
        val sections: ArrayList<ListSection?>? = ArrayList()
        if(value?.sections != null)
        {
            for(i in value.sections!!)
            {
                sections?.add(ListSectionMapper().mapFromKTOT(i))
            }
        }
        val tasks: ArrayList<Task?>? = ArrayList()
        if(value?.tasks != null)
        {
            for(i in value.tasks!!)
            {
                tasks?.add(TaskMapper().mapFromKTOT(i))
            }
        }
        return DataList(id = value?.id!!, name = value?.id, date = value?.date, author = value?.author, color = value?.color, V = value?.V,
            orderBy = value?.orderBy, order = value?.order, users = users, sections = sections, tasks = tasks)
    }
}