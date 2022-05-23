package com.example.ngs_test_login.MainActivity.Presentation.Main.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainAddFragment: Fragment()
{
    private val mainAddViewModel: MainViewModel by activityViewModels()
    private lateinit var navView: BottomNavigationView
    private lateinit var navHost: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var actionBar: MaterialToolbar
    private lateinit var actionBarLayout: AppBarLayout
    //TODO FIX
    private lateinit var nullIcon: ImageView
    private lateinit var nullText: TextView

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_main_add, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    //TODO GAVNO CODE
    private fun Init(view: View)
    {
        navView = view.findViewById(R.id.main_add_navigation_bar)

        navHost = childFragmentManager.findFragmentById(R.id.main_add_nav_host_fragment) as NavHostFragment
        navController = navHost.findNavController()
        navView.setupWithNavController(navController)

        actionBarLayout = view.findViewById(R.id.main_add_topAppBarLayout)
        actionBar = view.findViewById(R.id.main_add_topAppBar)

        navController.addOnDestinationChangedListener{
            controller, destination, arguments->
                actionBar.title = navController.currentDestination?.label
        }
    }
}