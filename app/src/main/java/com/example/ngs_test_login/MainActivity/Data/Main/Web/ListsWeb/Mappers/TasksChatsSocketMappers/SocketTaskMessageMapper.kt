package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers.TasksChatsSocketMappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksChatsSocketModels.SocketTaskMessageWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class SocketTaskMessageMapper: DoubleMapper<TaskMessage?, SocketTaskMessageWeb?>
{
    override fun mapFromTToK(value: TaskMessage?): SocketTaskMessageWeb?
    {
        return SocketTaskMessageWeb(id = value?.id, message = value?.message, date = value?.date, userId = value?.userId, allRead = value?.read)
    }

    override fun mapFromKTOT(value: SocketTaskMessageWeb?): TaskMessage?
    {
        return TaskMessage(id = value?.id, message = value?.message, date = value?.date, userId = value?.userId, read = value?.allRead)
    }
}