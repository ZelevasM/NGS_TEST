package com.example.ngs_test_login.MainActivity.Presentation.Main.Fragments

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.RelativeLayout
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.TaskViewPagerAdapter
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.text.SimpleDateFormat
import java.util.*

class MainTaskFragment: Fragment()
{
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var toolbar: MaterialToolbar
    private lateinit var appBarLayout: AppBarLayout
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    private lateinit var assignTo: RelativeLayout
    private lateinit var remindMe: RelativeLayout
    private lateinit var dueDate: RelativeLayout
    private lateinit var addNoteHolder: RelativeLayout



    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_main_task,container,false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    //TODO GAVNO CODE
    @SuppressLint("ResourceAsColor","SimpleDateFormat","WeekBasedYear")
    private fun Init(view: View)
    {
        appBarLayout = view.findViewById(R.id.main_task_toolbar_layout)
        toolbar = view.findViewById(R.id.main_task_toolbar)
        toolbar.isTitleCentered = true
        toolbar.title = mainViewModel.getCurrentListName()
        toolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_mainTaskFragment_to_mainListFragment)
        }

        tabLayout = view.findViewById(R.id.fragment_main_task_tabLayout)
        viewPager = view.findViewById(R.id.fragment_main_task_viewPager)
        val fragments: List<Fragment> = listOf(MainTaskCommentsFragment(), MainTaskAttachmentsFragment())
        val adapter = TaskViewPagerAdapter(fragments, this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            when(position)
            {
                0 -> {tab.text = "Comments"}
                1 -> {tab.text = "Attachments"}
            }
        }.attach()

        assignTo = view.findViewById(R.id.main_task_assignTo_holder)
        assignTo.setOnClickListener {
            val currentTaskId = mainViewModel.getCurrentTaskID()
            val currentListId = mainViewModel.getCurrentListID()
            if(currentTaskId != null && currentListId != null)
            {
                val timeD: Long = System.currentTimeMillis()
                val TIME_DATE_PATTERN: String = "EE MM dd yyyy hh:mm:ss z"

                val date = SimpleDateFormat("d M yyyy h:m:s:SSS").parse("4 6 2022 2:4:41:19").time

                Log.d("MyLog", "Millis: $timeD")
                Log.d("MyLog", "To Norm: ${SimpleDateFormat("d M yyyy h:m:s:SSS").format(timeD)}")
                //mainViewModel.assignTask(currentTaskId, currentListId, "62a1a832c7c8e80568614d36")
            }
        }

        remindMe = view.findViewById(R.id.main_task_remindMe_holder)
        remindMe.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)

            val datePickerDialog = DatePickerDialog(requireContext(),
                object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?,year: Int,month: Int,dayOfMonth: Int)
                {
                    Log.d("MyLog", "Day: $dayOfMonth \n Month: ${month+1} \n Year: $year")
                    val currentTaskId = mainViewModel.getCurrentTaskID()
                    val currentListId = mainViewModel.getCurrentListID()
                    if(currentTaskId != null && currentListId != null)
                    {
                        var hour = calendar.get(Calendar.HOUR_OF_DAY)
                        var minute = calendar.get(Calendar.MINUTE)
                        var second = calendar.get(Calendar.SECOND)
                        var millSecond = calendar.get(Calendar.MILLISECOND)
                        val timePickerDialog = TimePickerDialog(requireContext(), object : TimePickerDialog.OnTimeSetListener
                        {
                            override fun onTimeSet(view: TimePicker?,hourOfDay: Int,minute: Int)
                            {
                                Log.d("MyLog", "Hour: $hourOfDay \n Minute: $minute \n second: $second \n Millis: $millSecond")

                                val date = SimpleDateFormat("d M yyyy h:m:s:SSS").
                                parse("$dayOfMonth ${month+1} $year $hourOfDay:$minute:0:0").time

                                Log.d("MyLog", "Millis2: $date")

                                mainViewModel.remindTask(currentTaskId, currentListId, date.toString())
                            }
                        }, hour, minute, DateFormat.is24HourFormat(requireContext()))
                        timePickerDialog.show()
                    }
                }

            }, year, month, day)
            datePickerDialog.show()
        }

        dueDate = view.findViewById(R.id.main_task_dueDate_holder)
        dueDate.setOnClickListener {
            val currentTaskId = mainViewModel.getCurrentTaskID()
            val currentListId = mainViewModel.getCurrentListID()
            if(currentTaskId != null && currentListId != null)
            {
                val calendar: Calendar = Calendar.getInstance()
                val day = calendar.get(Calendar.DAY_OF_MONTH)
                val month = calendar.get(Calendar.MONTH)
                val year = calendar.get(Calendar.YEAR)

                val datePickerDialog = DatePickerDialog(requireContext(),
                    object : DatePickerDialog.OnDateSetListener{
                        override fun onDateSet(view: DatePicker?,year: Int,month: Int,dayOfMonth: Int)
                        {
                            Log.d("MyLog", "Day: $dayOfMonth \n Month: $month \n Year: $year")
                        }

                    }, year, month, day)
                datePickerDialog.show()

                val currentTaskId = mainViewModel.getCurrentTaskID()
                val currentListId = mainViewModel.getCurrentListID()
                if(currentTaskId != null && currentListId != null)
                {
                    mainViewModel.dateTask(currentTaskId, currentListId, "2022-06-29T09:00:03.128Z")
                }
            }
        }

        addNoteHolder = view.findViewById(R.id.main_task_addNote_holder)
        addNoteHolder.setOnClickListener {
            findNavController().navigate(R.id.action_mainTaskFragment_to_mainTaskAddNoteFragment)
        }

        mainViewModel.singleTaskLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if(it?.assign != null && it.id == mainViewModel.getCurrentTaskID())
            {

            }
        })
    }
}