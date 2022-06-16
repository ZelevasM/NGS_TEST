package com.example.ngs_test_login.MainActivity.Presentation.Main.Fragments.MainAddFragments

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
import androidx.navigation.findNavController
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.R

class MainAddListFragment: Fragment()
{
    private val mainAddListViewModel: MainViewModel by activityViewModels()
    private lateinit var listName: EditText
    private lateinit var addMemberButton: Button
    private lateinit var createList: Button
    private lateinit var cancelButton: Button


//
//    private lateinit var actionBar: MaterialToolbar
//    private lateinit var actionBarLayout: AppBarLayout
//    private lateinit var navHost: NavHostFragment

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

        val host: Int = R.id.main_activity_nav_host_fragment
        val destination: Int = R.id.mainFragment3

        createList.setOnClickListener {
            val name: String = listName.text.toString()
            val nameChecker: Boolean = verifyName(name)
            if(nameChecker)
            {
                mainAddListViewModel.addList(name)
                Toast.makeText(activity,"Added: $name",Toast.LENGTH_LONG).show()
                requireActivity().findNavController(host).popBackStack(destination, true)
                requireActivity().findNavController(host).navigate(destination)
            }
            else
            {
                Toast.makeText(activity,"Wrong",Toast.LENGTH_LONG).show()
            }
        }

        cancelButton.setOnClickListener {
            requireActivity().findNavController(host).popBackStack(destination, true)
            requireActivity().findNavController(host).navigate(destination)
        }


//        navHost = childFragmentManager.findFragmentById(R.id.main_add_nav_host_fragment) as NavHostFragment
//
//        actionBar = requireActivity().findViewById(R.id.main_add_topAppBar)
//
////        val host: Int = R.id.main_activity_nav_host_fragment
////        val destination: Int = R.id.mainFragment3
//        actionBar.setOnMenuItemClickListener {
//            if(it.itemId == R.id.action_done)
//            {
//                requireActivity().findNavController(host).popBackStack(destination, true)
//                requireActivity().findNavController(host).navigate(destination)
//            }
//            true
//        }
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