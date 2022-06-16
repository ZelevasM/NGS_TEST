package com.example.ngs_test_login.MainActivity.Presentation.User.Fragments

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Switch
import androidx.core.content.ContextCompat
import com.example.ngs_test_login.MainActivity.Data.User.Web.Models.ShortcutWeb
import com.example.ngs_test_login.R

class ShortcutsStateChecker(private val switches: ArrayList<Switch?>?, private val context: Context)
{
    @SuppressLint("ResourceType")
    fun summarize(): ArrayList<ShortcutWeb?>?
    {
        val shortcutWebs: ArrayList<ShortcutWeb?>? = ArrayList()
       if(switches?.get(0)?.isChecked == true)
       {
           val color: String = getColor(R.color.dark_blue)
           val inboxShort = ShortcutWeb(type = "inbox", color = color, projectId = "BniBhUlKE0ZxBWq+ERWlnWI=")
           shortcutWebs?.add(inboxShort)
       }
        if(switches?.get(1)?.isChecked == true)
        {
            val color: String = getColor(R.color.dark_green)
            val todayShort = ShortcutWeb(type = "today", color = color)
            shortcutWebs?.add(todayShort)
        }
        if(switches?.get(2)?.isChecked == true)
        {
            val color: String = getColor(R.color.dark_orange)
            val assShort = ShortcutWeb(type = "assigned_to_me", color = color)
            shortcutWebs?.add(assShort)
        }
        if(switches?.get(3)?.isChecked == true)
        {
            val color: String = getColor(R.color.lime_yellow)
            val mediumShort = ShortcutWeb(type = "medium_priority", color = color)
            shortcutWebs?.add(mediumShort)
        }
        if(switches?.get(4)?.isChecked == true)
        {
            val color: String = getColor(R.color.grapefruit_red)
            val highShort = ShortcutWeb(type = "high_priority", color = color)
            shortcutWebs?.add(highShort)
        }
        return shortcutWebs
    }

    fun getColor(id: Int): String
    {
        return String.format("#%06x",
            ContextCompat.getColor(context,id) and 0xffffff)
    }
}