package com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Mappers

import com.example.ngs_test_login.MainActivity.Data.Main.Web.ListsWeb.Models.TaskUserWeb
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskUser
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper

class TaskUserMapper: DoubleMapper<TaskUser?, TaskUserWeb?>
{
    override fun mapFromTToK(value: TaskUser?): TaskUserWeb?
    {
        return TaskUserWeb(id = value?.id, muted = value?.muted, order = value?.order, noteSize = value?.noteSize, unreadMessage = value?.unreadMessage,
        lastSeen = value?.lastSeen)
    }

    override fun mapFromKTOT(value: TaskUserWeb?): TaskUser?
    {
        return TaskUser(id = value?.id, muted = value?.muted, order = value?.order, noteSize = value?.noteSize, unreadMessage = value?.unreadMessage,
            lastSeen = value?.lastSeen)
    }
}