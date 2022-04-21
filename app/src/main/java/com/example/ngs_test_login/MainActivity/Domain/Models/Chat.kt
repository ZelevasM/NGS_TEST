package com.example.ngs_test_login.MainActivity.Domain.Models

data class Chat(private val id: String, private val name: String,
           private val author: String, private val date: String,
           private val users: ArrayList<User>, private val sections: ArrayList<String>,
           private val tasks: ArrayList<Task>)
{
    /*TODO
    *  1. Sections
    *  2. Users
    *  3. Tasks
    * */
}