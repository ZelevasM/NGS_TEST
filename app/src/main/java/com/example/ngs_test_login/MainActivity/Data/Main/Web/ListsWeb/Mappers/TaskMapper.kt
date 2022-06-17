package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskMessageWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskUserWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskUser
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class TaskMapper: DoubleMapper<Task?, TaskWeb?>
{
    override fun mapFromTToK(value: Task?): TaskWeb?
    {
        val messages: ArrayList<TaskMessageWeb?>? = ArrayList()
        if(value?.messages != null)
        {
            for (i in value.messages!!)
            {
                messages?.add(TaskMessageMapper().mapFromTToK(i))
            }
        }
        val users: ArrayList<TaskUserWeb?>? = ArrayList()
        if(value?.users != null)
        {
            for(i in value.users!!)
            {
                users?.add(TaskUserMapper().mapFromTToK(i))
            }
        }
        return TaskWeb(id = value?.id, name = value?.name, priority = value?.priority, done = value?.done, date = value?.date, order = value?.order,
        auth = value?.auth, notes = value?.notes, parent = value?.parent, section = value?.section,
            assign = TaskAssignMapper().mapFromTToK(value?.assign),users = users, messages = messages)
    }

    override fun mapFromKTOT(value: TaskWeb?): Task?
    {
        val messages: ArrayList<TaskMessage?>? = ArrayList()
        if(value?.messages != null)
        {
            for (i in value.messages!!)
            {
                messages?.add(TaskMessageMapper().mapFromKTOT(i))
            }
        }
        val users: ArrayList<TaskUser?>? = ArrayList()
        if(value?.users != null)
        {
            for(i in value.users!!)
            {
                users?.add(TaskUserMapper().mapFromKTOT(i))
            }
        }
        return Task(id = value?.id, name = value?.name, priority = value?.priority, done = value?.done, date = value?.date, order = value?.order,
            auth = value?.auth, notes = value?.notes, parent = value?.parent, section = value?.section,
            assign = TaskAssignMapper().mapFromKTOT(value?.assign),users = users, messages = messages)
    }
}