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
import androidx.navigation.fragment.findNavController
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.MainActivity.Presentation.User.SettingsBaseSpinner
import com.example.ngs_test_login.MainActivity.Presentation.User.UserViewModel
import com.example.ngs_test_login.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar

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
    private lateinit var actionBar: MaterialToolbar
    private lateinit var actionBarLayout: AppBarLayout


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
        val langBaseSpinner = SettingsBaseSpinner(languageSpinner, itemArray, requireContext())
        val flag: String? = "lang"
        langBaseSpinner.assign(flag, userViewModel)


        //  TODO DELETE
        val itemArrayHome: Array<String> = arrayOf("Inbox", "Today")
        val homepageBaseSpinner = SettingsBaseSpinner(homepageSpinner, itemArrayHome, requireContext())
        val flagHome = "homepage"
        homepageBaseSpinner.assign(flagHome, userViewModel)
//        userViewModel.userHomepageLiveData.observe(viewLifecycleOwner, Observer {
//            homepageSpinner.prompt = it
//        })

        val itemArrayDate: Array<String> = arrayOf("DD/MM/YYYY", "MM/DD/YYYY")
        val dateFormatBaseSpinner = SettingsBaseSpinner(dateFormatSpinner, itemArrayDate, requireContext())
        val flagDate = "dateFormat"
        dateFormatBaseSpinner.assign(flagDate, userViewModel)
        userViewModel.userDateFormatLiveData.observe(viewLifecycleOwner, Observer {
            if(it == itemArrayDate[0])
                dateFormatSpinner.setSelection(0)
            else
                dateFormatSpinner.setSelection(1)
        })

        val itemArrayTime: Array<String> = arrayOf("1:00 PM", "13:00")
        val timeFormatBaseSpinner = SettingsBaseSpinner(timeFormatSpinner, itemArrayTime, requireContext())
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
        val weekStartBaseSpinner = SettingsBaseSpinner(weekStartSpinner, itemArrayWeek, requireContext())
        val flagWeek ="weekStart"
        weekStartBaseSpinner.assign(flagWeek, userViewModel)
        userViewModel.userWeekStartLiveData.observe(viewLifecycleOwner, Observer {
            if(it == itemArrayWeek[0])
                weekStartSpinner.setSelection(0)
            else
                weekStartSpinner.setSelection(1)
        })

        val itemArrayExpandSubtask: Array<String> = arrayOf("Enabled", "Disabled")
        val expandSubtaskBaseSpinner = SettingsBaseSpinner(expandSubtaskSpinner, itemArrayExpandSubtask, requireContext())
        val flagSubtask ="expandSubtask"
        expandSubtaskBaseSpinner.assign(flagSubtask, userViewModel)
        userViewModel.userSubtaskLiveData.observe(viewLifecycleOwner, Observer {
            if(it == itemArrayExpandSubtask[0])
                expandSubtaskSpinner.setSelection(0)
            else
                expandSubtaskSpinner.setSelection(1)
        })

        val itemArrayNewTask: Array<String> = arrayOf("Top", "Bottom")
        val newTaskBaseSpinner = SettingsBaseSpinner(newTaskSpinner, itemArrayNewTask, requireContext())
        val flagNew ="newTask"
        newTaskBaseSpinner.assign(flagNew, userViewModel)
        userViewModel.userNewTaskLiveData.observe(viewLifecycleOwner, Observer {
            if(it == itemArrayNewTask[0])
                newTaskSpinner.setSelection(0)
            else
                newTaskSpinner.setSelection(1)
        })

        actionBarLayout = view.findViewById(R.id.profile_toolbar_layout)
        actionBar = view.findViewById(R.id.profile_toolbar)
        actionBar.isTitleCentered = true
        actionBar.title = getString(R.string.gen_settings)
//        val host: Int = R.id.main_activity_nav_host_fragment
//        val destination: Int = R.id.mainFragment3
        actionBar.setNavigationOnClickListener {
//            requireActivity().findNavController(host).popBackStack(destination,true)
//            requireActivity().findNavController(host).navigate(destination)
            findNavController().popBackStack()
            findNavController().navigate(R.id.mainProfileFragment)
        }
    }
}