package com.example.ngs_test_login.MainActivity.Presentation.Main.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.TasksExpandableListAdapter
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar

class MainListFragment: Fragment()
{
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var tasksList: ExpandableListView
    private lateinit var actionBar: MaterialToolbar
    private lateinit var actionBarLayout: AppBarLayout

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,
                              savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_main_list, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    //TODO GAVNO CODE
    private fun Init(view: View)
    {
        actionBarLayout = view.findViewById(R.id.main_list_toolbar_layout)
        actionBar = view.findViewById(R.id.main_list_toolbar)
        actionBar.isTitleCentered = true
        actionBar.title = mainViewModel.getCurrentListName()
        val host: Int = R.id.main_activity_nav_host_fragment
        val destination: Int = R.id.mainFragment3
        actionBar.setNavigationOnClickListener {
            requireActivity().findNavController(host).popBackStack(destination,true)
            requireActivity().findNavController(host).navigate(destination)
        }
        tasksList = view.findViewById(R.id.main_list_tasks_expandableListView)


        //TESTING
        val groups: ArrayList<String> = ArrayList()
        val children: HashMap<String, ArrayList<String>> = HashMap()
        for(i in 0 until 5)
        {
            groups.add("Task: $i")
            val childrenArray = ArrayList<String>()
            for(j in 0 until 5)
            {
                childrenArray.add("SubTask: $j")
            }
            children.put(groups[i], childrenArray)
        }
        val tasksListAdapter: TasksExpandableListAdapter = TasksExpandableListAdapter(requireContext(), groups, children)
        tasksList.setAdapter(tasksListAdapter)
    }
}