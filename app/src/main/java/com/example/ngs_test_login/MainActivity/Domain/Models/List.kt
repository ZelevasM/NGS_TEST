package com.example.ngs_test_login.MainActivity.Domain.Models

import java.text.DateFormat

class List(private val id: String, private val name: String,
           private val author: String, private val date: String,
           private val showSidebar: Boolean, private val shortcuts: ArrayList<String>,
           private val users: ArrayList<User>, private val sections: String,
           private val tasks: ArrayList<Task>)
{

}