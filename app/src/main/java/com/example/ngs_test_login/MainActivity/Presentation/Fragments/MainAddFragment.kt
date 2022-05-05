package com.example.ngs_test_login.MainActivity.Presentation.Fragments

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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngs_test_login.MainActivity.Domain.Models.Chat
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.ChatAdapter
import com.example.ngs_test_login.MainActivity.Presentation.MainViewModel
import com.example.ngs_test_login.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainAddFragment: Fragment()
{
    private val mainAddViewModel: MainViewModel by activityViewModels()
    private lateinit var navView: BottomNavigationView
    private lateinit var navHost: NavHostFragment
    private lateinit var navController: NavController
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
    }
}