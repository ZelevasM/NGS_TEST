package com.example.ngs_test_login.LoginActivity.Domain.Models

/**
 * model User is used to contain all the fields,
 * that can be accessed by the server,
 * and related as an entity
 * @sample user can be sent only with field filled, as well as all fields filled,
 * so it makes easier to communicate between different classes, instances, functions and etc.
 */
class UserFromLogin(private val name: String,private val email: String,private val password: String)
{
    var n = name
    var e = email
    var p = password
}