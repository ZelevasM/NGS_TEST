package com.example.ngs_test_login.MainActivity.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.core.graphics.luminance
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.navArgument
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ngs_test_login.LoginActivity.Presentation.Fragments.LoginFragment
import com.example.ngs_test_login.LoginActivity.Presentation.LoginViewModel
import com.example.ngs_test_login.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity()
{
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var navView: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var actionBar: MaterialToolbar
    private lateinit var actionBarLayout: AppBarLayout


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Init()
        getData()
    }

    private fun Init()
    {
        navView = findViewById(R.id.main_navigation_bar)

        navController = findNavController(R.id.main_nav_host_fragment)

        actionBar = findViewById(R.id.topAppBar)
        actionBarLayout = findViewById(R.id.topAppBarLayout)

        navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener {
                controller, destination, arguments ->
            actionBar.title = navController.currentDestination?.label
        }
    }

    private fun getData()
    {
        mainViewModel.getData()
    }
    //TODO Init(view)

    /* Passing each menu ID as a set of Ids because each
     menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_shortcuts,
            R.id.navigation_lists,
            R.id.navigation_chats))
    setupActionBarWithNavController(navController,appBarConfiguration)
    supportActionBar?.elevation = 0f*/
}