package com.example.ngs_test_login.MainActivity.Presentation.Main.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

class MainTaskFragment: Fragment()
{
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var toolbar: MaterialToolbar
    private lateinit var appBarLayout: AppBarLayout
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

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
    }
}