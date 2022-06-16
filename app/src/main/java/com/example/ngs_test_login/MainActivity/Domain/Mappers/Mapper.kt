package com.example.ngs_test_login.MainActivity.Domain.Mappers

interface Mapper <T, K>
{
    fun map(value: T): K
}