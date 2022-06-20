package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers.TasksSocketMappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksSocketModels.SocketReceiveTaskWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class SocketReceiveTaskMapper: DoubleMapper<Task?, SocketReceiveTaskWeb?>
{
    override fun mapFromTToK(value: Task?): SocketReceiveTaskWeb?
    {
        TODO("Not yet implemented")
    }

    override fun mapFromKTOT(value: SocketReceiveTaskWeb?): Task?
    {
        TODO("Not yet implemented")
    }
}