package com.example.ngs_test_login.MainActivity.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.ngs_test_login.MainActivity.Presentation.Fragments.MainFragment
import com.example.ngs_test_login.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity()
{
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var navView: BottomNavigationView
    private lateinit var navHost: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Init()
        socketInit()
        getData()
        //addList()
    }

    private fun Init()
    {
        navController = findNavController(R.id.main_activity_nav_host_fragment)
        //supportFragmentManager.beginTransaction().replace(R.id.main_container,MainFragment.newInstance()).commit()
    }

    private fun getData()
    {
        mainViewModel.getData()
    }

    private fun socketInit()
    {
        mainViewModel.socketInit()
    }

    private fun addList()
    {
        mainViewModel.addList()
    }


    /* Passing each menu ID as a set of Ids because each
     menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_shortcuts,
            R.id.navigation_lists,
            R.id.navigation_chats))
    setupActionBarWithNavController(navController,appBarConfiguration)
    supportActionBar?.elevation = 0f*/
}