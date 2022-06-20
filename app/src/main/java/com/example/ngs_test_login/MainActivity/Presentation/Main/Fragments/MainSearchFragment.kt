package com.example.ngs_test_login.MainActivity.Presentation.Main.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ngs_test_login.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar

class MainSearchFragment: Fragment()
{
    private lateinit var toolbar: MaterialToolbar
    private lateinit var actionBarLayout: AppBarLayout
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_main_search, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    //TODO GAVNO CODE
    private fun Init(view: View)
    {
        actionBarLayout = view.findViewById(R.id.main_search_toolbar_layout)
        toolbar = view.findViewById(R.id.main_search_toolbar)
        toolbar.isTitleCentered = true

        val host: Int = R.id.main_activity_nav_host_fragment
        val destination: Int = R.id.mainFragment3
        toolbar.setNavigationOnClickListener {
            requireActivity().findNavController(host).popBackStack(destination,true)
            requireActivity().findNavController(host).navigate(destination)
        }
    }
}