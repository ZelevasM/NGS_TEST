package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskMessageFileWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskMessageReplyWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessageFile
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessageReply
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class TaskMessageReplyMapper: DoubleMapper<TaskMessageReply?, TaskMessageReplyWeb?>
{
    override fun mapFromTToK(value: TaskMessageReply?): TaskMessageReplyWeb?
    {
        val files: ArrayList<TaskMessageFileWeb?>? = ArrayList()
        if(value?.files != null)
        {
            for (i in value.files)
            {
                files?.add(TaskMessageFileMapper().mapFromTToK(i))
            }
        }
        return TaskMessageReplyWeb(files = files)
    }

    override fun mapFromKTOT(value: TaskMessageReplyWeb?): TaskMessageReply?
    {
        val files: ArrayList<TaskMessageFile?>? = ArrayList()
        if(value?.files != null)
        {
            for (i in value.files)
            {
                files?.add(TaskMessageFileMapper().mapFromKTOT(i))
            }
        }
       return TaskMessageReply(files = files)
    }

}