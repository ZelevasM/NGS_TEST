package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers.TasksSocketMappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksSocketModels.SocketReceiveTaskSecondWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class SocketReceiveTaskSecondMapper: DoubleMapper<Task?, SocketReceiveTaskSecondWeb?>
{
    override fun mapFromTToK(value: Task?): SocketReceiveTaskSecondWeb?
    {
        TODO("Not yet implemented")
    }

    override fun mapFromKTOT(value: SocketReceiveTaskSecondWeb?): Task?
    {
        TODO("Not yet implemented")
    }
}