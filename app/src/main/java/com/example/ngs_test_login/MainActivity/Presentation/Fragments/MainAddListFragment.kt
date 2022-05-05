package com.example.ngs_test_login.MainActivity.Presentation.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.ngs_test_login.LoginActivity.Presentation.Fragments.EmailFragment
import com.example.ngs_test_login.MainActivity.Presentation.MainViewModel
import com.example.ngs_test_login.R

class MainAddListFragment: Fragment()
{
    private val mainAddListViewModel: MainViewModel by activityViewModels()
    private lateinit var listName: EditText
    private lateinit var addMemberButton: Button
    private lateinit var createList: Button
    private lateinit var cancelButton: Button

    private lateinit var navHost: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_main_add_list, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    @SuppressLint("ResourceType")
    private fun Init(view: View)
    {
        listName = view.findViewById(R.id.main_add_list_name)

        addMemberButton = view.findViewById(R.id.main_add_list_add_button)
        createList = view.findViewById(R.id.main_add_list_create_button)
        cancelButton = view.findViewById(R.id.main_add_list_cancel_button)

        createList.setOnClickListener {
            val name: String = listName.text.toString()
            val nameChecker: Boolean = verifyName(name)
            if(nameChecker)
            {
                mainAddListViewModel.addList(name)
                Toast.makeText(activity,"Added",Toast.LENGTH_LONG).show()
                requireActivity().findNavController(R.id.main_activity_nav_host_fragment).navigate(R.id.mainFragment3)
            }
            else
            {
                Toast.makeText(activity,"Wrong",Toast.LENGTH_LONG).show()
            }
        }

        cancelButton.setOnClickListener {
            requireActivity().findNavController(R.id.main_activity_nav_host_fragment).navigate(R.id.mainFragment3)
        }
    }

    private fun verifyName(name: String): Boolean
    {
        var checker = false
        if(name.isNotEmpty())
        {
            checker = true
        }
        return checker
    }

}