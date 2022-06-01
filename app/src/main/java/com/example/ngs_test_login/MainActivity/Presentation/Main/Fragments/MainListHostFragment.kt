package com.example.ngs_test_login.MainActivity.Presentation.Main.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.DataListAdapter
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.R

class MainListHostFragment: Fragment()
{
    private val listViewModel: MainViewModel by activityViewModels()
    private lateinit var navHost: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_main_list_host, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    //TODO GAVNO CODE
    private fun Init(view: View)
    {
        navHost = childFragmentManager.findFragmentById(R.id.main_list_nav_host_fragment) as NavHostFragment
        navController = navHost.findNavController()
    }
}