package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers.TasksChatsSocketMappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksChatsSocketModels.SocketTaskMessageSecondWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class SocketTaskMessageSecondMapper: DoubleMapper<TaskMessage?, SocketTaskMessageSecondWeb?>
{
    override fun mapFromTToK(value: TaskMessage?): SocketTaskMessageSecondWeb?
    {
        return SocketTaskMessageSecondWeb(id = value?.id, message = value?.message, date = value?.date, userId = value?.userId, allRead = value?.read)
    }

    override fun mapFromKTOT(value: SocketTaskMessageSecondWeb?): TaskMessage?
    {
        return TaskMessage(id = value?.id, message = value?.message, date = value?.date, userId = value?.userId, read = value?.allRead)
    }
}