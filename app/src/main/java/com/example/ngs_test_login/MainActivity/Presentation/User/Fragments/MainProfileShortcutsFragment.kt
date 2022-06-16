package com.example.ngs_test_login.MainActivity.Presentation.User.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.MainActivity.Presentation.User.UserViewModel
import com.example.ngs_test_login.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar

class MainProfileShortcutsFragment: Fragment()
{
    private val mainViewModel: MainViewModel by activityViewModels()
    private val userViewModel: UserViewModel by activityViewModels()
    private lateinit var actionBar: MaterialToolbar
    private lateinit var actionBarLayout: AppBarLayout
    private lateinit var inboxSwitch: Switch
    private lateinit var todaySwitch: Switch
    private lateinit var assignedSwitch: Switch
    private lateinit var mediumSwitch: Switch
    private lateinit var highSwitch: Switch

    //TODO FIX
    private lateinit var nullIcon: ImageView
    private lateinit var nullText: TextView

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_profile_shortcuts, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    //TODO GAVNO CODE
    private fun Init(view: View)
    {
        actionBarLayout = view.findViewById(R.id.profile_short_toolbar_layout)
        actionBar = view.findViewById(R.id.profile_short_toolbar)
        actionBar.isTitleCentered = true
        actionBar.title = getString(R.string.shortcuts)
        actionBar.setNavigationOnClickListener {
            findNavController().popBackStack()
            findNavController().navigate(R.id.mainProfileFragment)
        }

        inboxSwitch = view.findViewById(R.id.profile_short_inbox_switch)
        todaySwitch = view.findViewById(R.id.profile_short_today_switch)
        assignedSwitch = view.findViewById(R.id.profile_short_assigned_switch)
        mediumSwitch = view.findViewById(R.id.profile_short_medium_priority_switch)
        highSwitch = view.findViewById(R.id.profile_short_high_priority_switch)
        val switches: ArrayList<Switch?>? = ArrayList()
        switches?.add(inboxSwitch)
        switches?.add(todaySwitch)
        switches?.add(assignedSwitch)
        switches?.add(mediumSwitch)
        switches?.add(highSwitch)

        userViewModel.shortcutsLiveData.observe(viewLifecycleOwner, Observer {
            val shortcuts = it
//            inboxSwitch.isChecked = false
//            todaySwitch.isChecked = false
//            assignedSwitch.isChecked = false
//            mediumSwitch.isChecked = false
//            highSwitch.isChecked = false
            if(shortcuts !=null)
            {
                for (i in shortcuts.indices)
                {
                    when (shortcuts[i]?.type)
                    {
                        "inbox" ->  inboxSwitch.isChecked = true
                        "today" -> todaySwitch.isChecked = true
                        "assigned_to_me" -> assignedSwitch.isChecked = true
                        "medium_priority" -> mediumSwitch.isChecked = true
                        "high_priority" -> highSwitch.isChecked = true
                    }
                    val type = shortcuts[i]?.type
                }
                val shortcutsStateChecker = ShortcutsStateChecker(switches,requireActivity())
                inboxSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                    userViewModel.changeShortcut(shortcutsStateChecker.summarize())
                }
                todaySwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                    userViewModel.changeShortcut(shortcutsStateChecker.summarize())
                }
                assignedSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                    userViewModel.changeShortcut(shortcutsStateChecker.summarize())
                }
                mediumSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                    userViewModel.changeShortcut(shortcutsStateChecker.summarize())
                    Log.d("MyLog","switched: $isChecked")
                }
                highSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                    userViewModel.changeShortcut(shortcutsStateChecker.summarize())
                }
            }
        })

    }
}