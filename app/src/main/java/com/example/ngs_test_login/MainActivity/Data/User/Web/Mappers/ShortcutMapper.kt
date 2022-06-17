package com.example.ngs_test_login.MainActivity.Data.User.Web.Mappers

import com.example.ngs_test_login.MainActivity.Data.User.Web.Models.ShortcutWeb
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut

class ShortcutMapper: DoubleMapper<Shortcut?, ShortcutWeb?>
{
    override fun mapFromTToK(value: Shortcut?): ShortcutWeb?
    {
        return ShortcutWeb(color = value?.color, type = value?.type, projectId = value?.projectId)
    }

    override fun mapFromKTOT(value: ShortcutWeb?): Shortcut?
    {
        return Shortcut(color = value?.color, type = value?.type, projectId = value?.projectId)
    }

}