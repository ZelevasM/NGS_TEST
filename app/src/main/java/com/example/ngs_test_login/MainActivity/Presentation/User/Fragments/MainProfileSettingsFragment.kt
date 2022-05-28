package com.example.ngs_test_login.MainActivity.Presentation.User.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.MainActivity.Presentation.User.UserViewModel
import com.example.ngs_test_login.R

class MainProfileSettingsFragment: Fragment()
{
    private val mainViewModel: MainViewModel by activityViewModels()
    private val userViewModel: UserViewModel by activityViewModels()

    private lateinit var languageSpinner: Spinner
    private lateinit var homepageSpinner: Spinner
    private lateinit var dateFormatSpinner: Spinner
    private lateinit var timeFormatSpinner: Spinner
    private lateinit var weekStartSpinner: Spinner
    private lateinit var expandSubtaskSpinner: Spinner
    private lateinit var newTaskSpinner: Spinner


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_profile_settings, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    //TODO GAVNO CODE
    @SuppressLint("ResourceType")
    private fun Init(view: View)
    {
        languageSpinner = view.findViewById(R.id.profile_language_menu)
        homepageSpinner = view.findViewById(R.id.profile_homepage_menu)
        dateFormatSpinner = view.findViewById(R.id.profile_date_format_menu)
        timeFormatSpinner = view.findViewById(R.id.profile_time_format_menu)
        weekStartSpinner = view.findViewById(R.id.profile_week_start_menu)
        expandSubtaskSpinner = view.findViewById(R.id.profile_expand_subtask_menu)
        newTaskSpinner = view.findViewById(R.id.profile_new_task_menu)

        val itemArray: Array<String> = arrayOf("English", "Uzbek", "Russian")
        val langBaseSpinner = SettingsBaseSpinner(languageSpinner, itemArray, context!!)
        val flag: String? = "lang"
        langBaseSpinner.assign(flag, userViewModel)


        //  TODO DELETE
        val itemArrayHome: Array<String> = arrayOf("Inbox", "Today")
        val homepageBaseSpinner = SettingsBaseSpinner(homepageSpinner, itemArrayHome, context!!)
        val flagHome = "homepage"
        homepageBaseSpinner.assign(flagHome, userViewModel)
//        userViewModel.userHomepageLiveData.observe(viewLifecycleOwner, Observer {
//            homepageSpinner.prompt = it
//        })

        val itemArrayDate: Array<String> = arrayOf("DD/MM/YYYY", "MM/DD/YYYY")
        val dateFormatBaseSpinner = SettingsBaseSpinner(dateFormatSpinner, itemArrayDate, context!!)
        val flagDate = "dateFormat"
        dateFormatBaseSpinner.assign(flagDate, userViewModel)
        userViewModel.userDateFormatLiveData.observe(viewLifecycleOwner, Observer {
            if(it == itemArrayDate[0])
                dateFormatSpinner.setSelection(0)
            else
                dateFormatSpinner.setSelection(1)
        })

        val itemArrayTime: Array<String> = arrayOf("1:00 PM", "13:00")
        val timeFormatBaseSpinner = SettingsBaseSpinner(timeFormatSpinner, itemArrayTime, context!!)
        val flagTime ="timeFormat"
        timeFormatBaseSpinner.assign(flagTime, userViewModel)
        userViewModel.userTimeFormatLiveData.observe(viewLifecycleOwner, Observer {
            Log.d("MyLog","time: $it")
            if(it == itemArrayTime[0])
                timeFormatSpinner.setSelection(0)
            else
                timeFormatSpinner.setSelection(1)
        })

        val itemArrayWeek: Array<String> = arrayOf("Monday", "Sunday")
        val weekStartBaseSpinner = SettingsBaseSpinner(weekStartSpinner, itemArrayWeek, context!!)
        val flagWeek ="weekStart"
        weekStartBaseSpinner.assign(flagWeek, userViewModel)
        userViewModel.userWeekStartLiveData.observe(viewLifecycleOwner, Observer {
            if(it == itemArrayWeek[0])
                weekStartSpinner.setSelection(0)
            else
                weekStartSpinner.setSelection(1)
        })

        val itemArrayExpandSubtask: Array<String> = arrayOf("Enabled", "Disabled")
        val expandSubtaskBaseSpinner = SettingsBaseSpinner(expandSubtaskSpinner, itemArrayExpandSubtask, context!!)
        val flagSubtask ="expandSubtask"
        expandSubtaskBaseSpinner.assign(flagSubtask, userViewModel)
        userViewModel.userSubtaskLiveData.observe(viewLifecycleOwner, Observer {
            if(it == itemArrayExpandSubtask[0])
                expandSubtaskSpinner.setSelection(0)
            else
                expandSubtaskSpinner.setSelection(1)
        })

        val itemArrayNewTask: Array<String> = arrayOf("Top", "Bottom")
        val newTaskBaseSpinner = SettingsBaseSpinner(newTaskSpinner, itemArrayNewTask, context!!)
        val flagNew ="newTask"
        newTaskBaseSpinner.assign(flagNew, userViewModel)
        userViewModel.userNewTaskLiveData.observe(viewLifecycleOwner, Observer {
            if(it == itemArrayNewTask[0])
                newTaskSpinner.setSelection(0)
            else
                newTaskSpinner.setSelection(1)
        })
    }
}