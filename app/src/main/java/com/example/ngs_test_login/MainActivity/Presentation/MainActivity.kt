package com.example.ngs_test_login.MainActivity.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.core.graphics.luminance
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ngs_test_login.LoginActivity.Presentation.Fragments.LoginFragment
import com.example.ngs_test_login.LoginActivity.Presentation.LoginViewModel
import com.example.ngs_test_login.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity()
{
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.main_navigation_bar)

        val navController = findNavController(R.id.main_nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_shortcuts,
            R.id.navigation_lists,
            R.id.navigation_chats))
        setupActionBarWithNavController(navController,appBarConfiguration)
        navView.setupWithNavController(navController)
        //supportActionBar?.elevation = 0f

    }
    //TODO Init(view)
}