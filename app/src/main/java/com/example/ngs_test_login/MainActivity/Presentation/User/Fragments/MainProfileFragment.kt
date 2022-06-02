package com.example.ngs_test_login.MainActivity.Presentation.User.Fragments

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.MainActivity.Presentation.User.UserViewModel
import com.example.ngs_test_login.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar

class MainProfileFragment: Fragment()
{
    private val mainViewModel: MainViewModel by activityViewModels()
    private val userViewModel: UserViewModel by activityViewModels()

    private lateinit var genSettings: LinearLayout
    private lateinit var userSettings: LinearLayout
    private lateinit var shortcutsSettings: LinearLayout
    private lateinit var userName: TextView
    private lateinit var userEmail: TextView
    private lateinit var actionBar: MaterialToolbar
    private lateinit var actionBarLayout: AppBarLayout

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    //TODO GAVNO CODE
    private fun Init(view: View)
    {
        genSettings = view.findViewById(R.id.main_profile_general_settings_layout)
        genSettings.setOnClickListener{
            findNavController().navigate(R.id.action_mainProfileFragment_to_mainProfileSettingsFragment)
        }
        userSettings = view.findViewById(R.id.main_profile_info_layout)
        userSettings.setOnClickListener {
            findNavController().navigate(R.id.action_mainProfileFragment_to_mainProfileUserSettings)
        }

        shortcutsSettings = view.findViewById(R.id.main_profile_shortcuts_layout)
        shortcutsSettings.setOnClickListener {
            findNavController().navigate(R.id.action_mainProfileFragment_to_mainProfileShortcutsFragment)
        }

        userName = view.findViewById(R.id.main_profile_info_name)
        userEmail = view.findViewById(R.id.main_profile_info_email)
        userViewModel.userNameLiveData.observe(viewLifecycleOwner, Observer {
            userName.text = it
        })
        userViewModel.userEmailLiveData.observe(viewLifecycleOwner, Observer {
            userEmail.text = it
        })

        actionBarLayout = view.findViewById(R.id.main_profile_toolbar_layout)
        actionBar = view.findViewById(R.id.main_profile_toolbar)
        actionBar.isTitleCentered = true
        actionBar.title = getString(R.string.settings)
        val host: Int = R.id.main_activity_nav_host_fragment
        val destination: Int = R.id.mainFragment3
        actionBar.setNavigationOnClickListener {
            requireActivity().findNavController(host).popBackStack(destination,true)
            requireActivity().findNavController(host).navigate(destination)
        }
    }
}