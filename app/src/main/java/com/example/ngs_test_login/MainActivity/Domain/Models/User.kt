package com.example.ngs_test_login.MainActivity.Domain.Models

import java.text.DateFormat

class User(private val id: String,private val dateFormat: DateFormat,
           private val token: String,private val diskSpace: String,
           private val showSidebar: Boolean,private val shortcuts: ArrayList<String>,
           private val language: String,private val newTask: String,
           private val homePage: String,private val expandSubtask: String,
           private val email: String,private val name: String,
           private val folder: String)
{

}