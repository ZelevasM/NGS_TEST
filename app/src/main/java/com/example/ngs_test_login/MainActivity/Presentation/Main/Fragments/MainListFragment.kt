package com.example.ngs_test_login.MainActivity.Presentation.Main.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.DataListAdapter
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.SimpleTaskAdapter
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar

class MainListFragment: Fragment()
{
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var tasksRecView: RecyclerView
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
        tasksRecView = view.findViewById(R.id.main_list_tasks_recView)
        tasksRecView.layoutManager = LinearLayoutManager(this.context)
        tasksRecView.setHasFixedSize(true)
        val simpleAdapter = SimpleTaskAdapter()
        mainViewModel.getLocalList(DataList(id = mainViewModel.getCurrentListID()!!))

        mainViewModel.singleListLiveData.observe(viewLifecycleOwner, Observer {
            if(it?.tasks != null)
            {
                Log.d("MyLog","LIIIIIIst: $it")
                val tasks: ArrayList<Task?>? = it.tasks
                simpleAdapter.tasks = tasks
                tasksRecView.adapter = simpleAdapter
                simpleAdapter.setOnItemClickListener(object: SimpleTaskAdapter.onItemClickListener{
                    override fun onItemClicked(position: Int, id: String?, name: String?)
                    {
                        super.onItemClicked(position, id, name)
                        Toast.makeText(activity,"$position + $id" ,Toast.LENGTH_SHORT).show()
                        mainViewModel.setCurrentTask(id = id, name = name)
                        findNavController().navigate(R.id.action_mainListFragment_to_mainTaskFragment)

                    }
                })
//                val parentTasks: ArrayList<Task?>? = ArrayList()
//                val childTasks: ArrayList<Task?>? = ArrayList()
////                for(i in tasks!!)
////                {
////                    if(i?.parent == null)
////                    {
////                        parentTasks?.add(i)
////                    }
////                }
////                for(i in tasks!!)
////                {
////                    if(i?.parent != null)
////                    {
////                        if (parentTasks != null)
////                        {
////                            for(j in parentTasks)
////                            {
////                                if(j?.id == i?.parent)
////                            }
////                        }
////                    }
////                }
            }
        })


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
    }
}