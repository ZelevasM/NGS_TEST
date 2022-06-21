package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers.TasksSocketMappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers.TaskAssignMapper
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers.TaskUserMapper
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskUserWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksSocketModels.SocketReceiveTaskSecondWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TasksSocketModels.SocketReceiveTaskWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskUser
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class SocketReceiveTaskSecondMapper: DoubleMapper<Task?, SocketReceiveTaskSecondWeb?>
{
    override fun mapFromTToK(value: Task?): SocketReceiveTaskSecondWeb?
    {
        val users: ArrayList<TaskUserWeb?>? = ArrayList()
        if(value?.users != null)
        {
            for(i in value.users!!)
            {
                users?.add(TaskUserMapper().mapFromTToK(i))
            }
        }
        return SocketReceiveTaskSecondWeb(id = value?.id, name = value?.name, parent = value?.parent, done = value?.done, notes = value?.notes,
            date = value?.date, authId = value?.auth, order = value?.order, assign = TaskAssignMapper().mapFromTToK(value?.assign), users = users)
    }

    override fun mapFromKTOT(value: SocketReceiveTaskSecondWeb?): Task?
    {
        val users: ArrayList<TaskUser?>? = ArrayList()
        if(value?.users != null)
        {
            for(i in value.users!!)
            {
                users?.add(TaskUserMapper().mapFromKTOT(i))
            }
        }
        return Task(id = value?.id, name = value?.name, parent = value?.parent, done = value?.done, notes = value?.notes,
            date = value?.date, auth = value?.authId, order = value?.order, assign = TaskAssignMapper().mapFromKTOT(value?.assign), users = users)
    }
}