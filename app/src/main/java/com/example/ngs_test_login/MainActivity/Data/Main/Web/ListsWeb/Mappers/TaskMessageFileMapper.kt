package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskMessageFileWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessageFile
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class TaskMessageFileMapper: DoubleMapper<TaskMessageFile?, TaskMessageFileWeb?>
{
    override fun mapFromTToK(value: TaskMessageFile?): TaskMessageFileWeb?
    {
        return TaskMessageFileWeb(id = value?.id, size = value?.size, filename = value?.filename, imgHeight = value?.imgHeight, imgWidth = value?.imgWidth,
        extension = value?.extension, date = value?.date)
    }

    override fun mapFromKTOT(value: TaskMessageFileWeb?): TaskMessageFile?
    {
        return TaskMessageFile(id = value?.id, size = value?.size, filename = value?.filename, imgHeight = value?.imgHeight, imgWidth = value?.imgWidth,
            extension = value?.extension, date = value?.date)
    }
}