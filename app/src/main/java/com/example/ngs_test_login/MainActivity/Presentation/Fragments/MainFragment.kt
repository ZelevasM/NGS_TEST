package com.example.ngs_test_login.MainActivity.Presentation.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavAction
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ngs_test_login.MainActivity.Presentation.MainViewModel
import com.example.ngs_test_login.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment: Fragment()
{
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var navView: BottomNavigationView
    private lateinit var navHost: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var actionBar: MaterialToolbar
    private lateinit var actionBarLayout: AppBarLayout
    private lateinit var addButton: Button
    //private lateinit var action: NavDirections


    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    //TODO GAVNO CODE
    private fun Init(view: View)
    {
        navView = view.findViewById(R.id.main_navigation_bar)

        navHost = childFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment
        navController = navHost.findNavController()

        actionBar = view.findViewById(R.id.topAppBar)
        actionBarLayout = view.findViewById(R.id.topAppBarLayout)

        navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener {
                controller, destination, arguments ->
            actionBar.title = navController.currentDestination?.label
        }

        addButton = view.findViewById(R.id.button_add)
        //action  = view.findViewById(R.id.action_mainFragment3_to_mainAddFragment)
        addButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment3_to_mainAddFragment)
        }
    }

}