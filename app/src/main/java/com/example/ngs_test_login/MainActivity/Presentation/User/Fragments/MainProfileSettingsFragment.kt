package com.example.ngs_test_login.MainActivity.Presentation.User.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
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

        var itemArray: Array<String> = arrayOf("English", "Uzbek", "Russian")
        val langBaseSpinner = SettingsBaseSpinner(languageSpinner, itemArray, context!!)
        var flag: String? = "lang"
        langBaseSpinner.assign(flag, userViewModel)


        //  TODO DELETE
        itemArray = arrayOf("Inbox", "Today")
        val homepageBaseSpinner = SettingsBaseSpinner(homepageSpinner, itemArray, context!!)
        flag = "homepage"
        homepageBaseSpinner.assign(flag, userViewModel)
        userViewModel.userHomepageLiveData.observe(viewLifecycleOwner, Observer {
            homepageSpinner.prompt = it
        })

        itemArray = arrayOf("DD/MM/YYYY", "MM/DD/YYYY")
        val dateFormatBaseSpinner = SettingsBaseSpinner(dateFormatSpinner, itemArray, context!!)
        flag = "dateFormat"
        dateFormatBaseSpinner.assign(flag, userViewModel)
        userViewModel.userDateFormatLiveData.observe(viewLifecycleOwner, Observer {
            when(it)
            {
                itemArray[0] -> dateFormatSpinner.setSelection(0)
                itemArray[1] -> dateFormatSpinner.setSelection(1)
            }
        })

        itemArray = arrayOf("1:OO PM", "13:00")
        val timeFormatBaseSpinner = SettingsBaseSpinner(timeFormatSpinner, itemArray, context!!)
        flag ="timeFormat"
        timeFormatBaseSpinner.assign(flag, userViewModel)

        itemArray = arrayOf("Monday", "Sunday")
        val weekStartBaseSpinner = SettingsBaseSpinner(weekStartSpinner, itemArray, context!!)
        flag ="weekStart"
        weekStartBaseSpinner.assign(flag, userViewModel)

        itemArray = arrayOf("Enabled", "Disabled")
        val expandSubtaskBaseSpinner = SettingsBaseSpinner(expandSubtaskSpinner, itemArray, context!!)
        flag ="expandSubtask"
        expandSubtaskBaseSpinner.assign(flag, userViewModel)

        itemArray = arrayOf("Top", "Bottom")
        val newTaskBaseSpinner = SettingsBaseSpinner(newTaskSpinner, itemArray, context!!)
        flag ="newTask"
        newTaskBaseSpinner.assign(flag, userViewModel)
    }
}