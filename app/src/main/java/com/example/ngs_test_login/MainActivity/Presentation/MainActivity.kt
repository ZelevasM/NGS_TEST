package com.example.ngs_test_login.MainActivity.Presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.ngs_test_login.MainActivity.Presentation.Base.BaseViewModel
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.MainActivity.Presentation.User.UserViewModel
import com.example.ngs_test_login.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity()
{
    private val baseViewModel: BaseViewModel by viewModels()
    private val mainViewModel: MainViewModel by viewModels()
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var navView: BottomNavigationView
    private lateinit var navHost: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Init()
        socketInit()
        getData(this)
        changeNameEmailPassword()
        //addList()
    }

    override fun onDestroy()
    {
        super.onDestroy()
    }

    private fun Init()
    {
        navController = findNavController(R.id.main_activity_nav_host_fragment)
        //supportFragmentManager.beginTransaction().replace(R.id.main_container,MainFragment.newInstance()).commit()
    }

    private fun getData(context: Context)
    {
        mainViewModel.getData(this)
    }

    private fun socketInit()
    {
        baseViewModel.socketInit()
        var response: Boolean = false
        baseViewModel.responseLiveData.observe(this, Observer {
            response = it
            if(response == true)
            {
                Toast.makeText(this,"CONNECTED", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this,"LOST CONNECTION", Toast.LENGTH_SHORT).show()
        })
        //mainViewModel.socketInit()
    }

    private fun changeNameEmailPassword()
    {
        //userViewModel.changeName()
        //userViewModel.changeEmail()
        //userViewModel.changePassword()
        //userViewModel.changeHomepage()
        //userViewModel.changeDateFormat()
        //userViewModel.changeTimeFormat()
        //userViewModel.changeStartOfWeek()
        //userViewModel.changeExpandSubtask()
        //userViewModel.changeNewTask()
    }
}