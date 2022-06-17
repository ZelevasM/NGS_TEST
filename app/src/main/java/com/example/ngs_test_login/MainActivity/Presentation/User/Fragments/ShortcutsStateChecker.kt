package com.example.ngs_test_login.MainActivity.Presentation.User.Fragments

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Switch
import androidx.core.content.ContextCompat
import com.example.ngs_test_login.MainActivity.Domain.User.Models.Shortcut
import com.example.ngs_test_login.R

class ShortcutsStateChecker(private val switches: ArrayList<Switch?>?, private val context: Context)
{
    @SuppressLint("ResourceType")
    fun summarize(): ArrayList<Shortcut?>?
    {
        val shortcuts: ArrayList<Shortcut?>? = ArrayList()
       if(switches?.get(0)?.isChecked == true)
       {
           val color: String = getColor(R.color.dark_blue)
           val inboxShort = Shortcut(type = "inbox", color = color, projectId = "BniBhUlKE0ZxBWq+ERWlnWI=")
           shortcuts?.add(inboxShort)
       }
        if(switches?.get(1)?.isChecked == true)
        {
            val color: String = getColor(R.color.dark_green)
            val todayShort = Shortcut(type = "today", color = color)
            shortcuts?.add(todayShort)
        }
        if(switches?.get(2)?.isChecked == true)
        {
            val color: String = getColor(R.color.dark_orange)
            val assShort = Shortcut(type = "assigned_to_me", color = color)
            shortcuts?.add(assShort)
        }
        if(switches?.get(3)?.isChecked == true)
        {
            val color: String = getColor(R.color.lime_yellow)
            val mediumShort = Shortcut(type = "medium_priority", color = color)
            shortcuts?.add(mediumShort)
        }
        if(switches?.get(4)?.isChecked == true)
        {
            val color: String = getColor(R.color.grapefruit_red)
            val highShort = Shortcut(type = "high_priority", color = color)
            shortcuts?.add(highShort)
        }
        return shortcuts
    }

    fun getColor(id: Int): String
    {
        return String.format("#%06x",
            ContextCompat.getColor(context,id) and 0xffffff)
    }
}