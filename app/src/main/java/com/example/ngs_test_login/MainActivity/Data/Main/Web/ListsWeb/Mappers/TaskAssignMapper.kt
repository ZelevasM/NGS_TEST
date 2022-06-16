package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskAssignWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskAssign
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class TaskAssignMapper: DoubleMapper<TaskAssign?, TaskAssignWeb?>
{
    override fun mapFromTToK(value: TaskAssign?): TaskAssignWeb?
    {
        return TaskAssignWeb(userId = value?.userId, date = value?.date, notif = value?.notif, remind = value?.remind)
    }

    override fun mapFromKTOT(value: TaskAssignWeb?): TaskAssign?
    {
        return TaskAssign(userId = value?.userId, date = value?.date, notif = value?.notif, remind = value?.remind)
    }
}