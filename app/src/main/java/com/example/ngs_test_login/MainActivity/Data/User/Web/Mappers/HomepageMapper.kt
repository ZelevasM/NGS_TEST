package com.example.ngs_test_login.MainActivity.Data.User.Web.Mappers

import com.example.ngs_test_login.MainActivity.Data.User.Web.Models.HomepageWeb
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Homepage

class HomepageMapper: DoubleMapper<Homepage?, HomepageWeb?>
{
    override fun mapFromTToK(value: Homepage?): HomepageWeb?
    {
        return HomepageWeb(type = value?.type)
    }

    override fun mapFromKTOT(value: HomepageWeb?): Homepage?
    {
        return Homepage(type = value?.type)
    }
}