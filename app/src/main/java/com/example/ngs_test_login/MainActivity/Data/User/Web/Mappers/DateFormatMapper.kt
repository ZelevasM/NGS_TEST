package com.example.ngs_test_login.MainActivity.Data.User.Web.Mappers

import com.example.ngs_test_login.MainActivity.Data.User.Web.Models.DateFormatWeb
import com.example.ngs_test_login.MainActivity.Domain.Mappers.DoubleMapper
import com.example.ngs_test_login.MainActivity.Domain.User.Models.DateFormat

class DateFormatMapper: DoubleMapper<DateFormat?,DateFormatWeb?>
{
    override fun mapFromTToK(value: DateFormat?): DateFormatWeb?
    {
        return DateFormatWeb(date = value?.date, startOfTheWeek = value?.startOfTheWeek, time = value?.time)
    }

    override fun mapFromKTOT(value: DateFormatWeb?): DateFormat?
    {
        return DateFormat(date = value?.date, startOfTheWeek = value?.startOfTheWeek, time = value?.time)
    }
}