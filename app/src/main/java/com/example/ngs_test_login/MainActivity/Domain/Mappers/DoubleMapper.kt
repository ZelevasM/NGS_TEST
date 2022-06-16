package com.example.ngs_test_login.MainActivity.Domain.Mappers

interface DoubleMapper <T, K>
{
    fun mapFromTToK(value: T): K

    fun mapFromKTOT(value: K): T
}