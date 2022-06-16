package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskMessageFileWeb
import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskMessageWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessageFile
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class TaskMessageMapper: DoubleMapper<TaskMessage?, TaskMessageWeb?>
{
    override fun mapFromTToK(value: TaskMessage?): TaskMessageWeb?
    {
        val files: ArrayList<TaskMessageFileWeb?>? = ArrayList()
        if(value?.files != null)
        {
            for(i in value.files)
            {
                files?.add(TaskMessageFileMapper().mapFromTToK(i))
            }
        }
        return TaskMessageWeb(id = value?.id, userId = value?.userId, read = value?.read, date = value?.date, message = value?.message,
            removeFile = value?.removeFile,reply = TaskMessageReplyMapper().mapFromTToK(value?.reply), files = files)
    }

    override fun mapFromKTOT(value: TaskMessageWeb?): TaskMessage?
    {
        val files: ArrayList<TaskMessageFile?>? = ArrayList()
        if(value?.files != null)
        {
            for(i in value.files)
            {
                files?.add(TaskMessageFileMapper().mapFromKTOT(i))
            }
        }
        return TaskMessage(id = value?.id, userId = value?.userId, read = value?.read, date = value?.date, message = value?.message,
            removeFile = value?.removeFile,reply = TaskMessageReplyMapper().mapFromKTOT(value?.reply), files = files)
    }
}