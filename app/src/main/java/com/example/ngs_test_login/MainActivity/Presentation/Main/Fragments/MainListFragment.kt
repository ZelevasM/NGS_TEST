package com.example.ngs_test_login.MainActivity.Presentation.Main.Fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginStart
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.DataList
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.Task
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.SimpleTaskAdapter
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar

class MainListFragment: Fragment()
{
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var tasksRecView: RecyclerView
    private lateinit var toolbar: MaterialToolbar
    private lateinit var actionBarLayout: AppBarLayout
    private lateinit var taskEditText: EditText
    private lateinit var addTaskButton: Button

    private lateinit var selectedTask: Task

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
        toolbar = view.findViewById(R.id.main_list_toolbar)
        toolbar.isTitleCentered = true
        toolbar.title = mainViewModel.getCurrentListName()
        val host: Int = R.id.main_activity_nav_host_fragment
        val destination: Int = R.id.mainFragment3
        toolbar.setNavigationOnClickListener {
            mainViewModel.setCurrentList(null, null)
            requireActivity().findNavController(host).popBackStack(destination,true)
            requireActivity().findNavController(host).navigate(destination)
        }
        toolbar.setOnMenuItemClickListener {
            if(it.itemId == R.id.action_users)
            {
                //NOT YET
            }
            if(it.itemId == R.id.action_sort)
            {
                //NOT YET
            }
            if(it.itemId == R.id.action_task_edit)
            {
                val listId = mainViewModel.getCurrentListID()
                if(listId != null)
                {
                    val renameEditText = EditText(requireContext())
                    val alertDialog = AlertDialog.Builder(requireContext()).setTitle("Enter the name: ").setView(renameEditText).
                    setPositiveButton("OK",object: DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?,which: Int)
                        {
                            val newName = renameEditText.text.toString()
                            if(verifyName(newName))
                            {
                                mainViewModel.renameTask(selectedTask.id!!, newName, listId)
                                revokeDefaultMenu()
                            }
                        }
                    }).
                    setNegativeButton("CANCEL", object: DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?,which: Int)
                        {
                            dialog?.cancel()
                        }
                    }).create()
                    alertDialog.setOnShowListener {
                        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK)
                        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK)
                    }

                    alertDialog.show()
                }
            }
            if(it.itemId == R.id.action_task_delete)
            {
                val listId = mainViewModel.getCurrentListID()
                if(listId != null)
                    mainViewModel.deleteTask(selectedTask.id!!, listId)

                revokeDefaultMenu()
            }
            true
        }
        tasksRecView = view.findViewById(R.id.main_list_tasks_recView)
        tasksRecView.layoutManager = LinearLayoutManager(this.context)
        tasksRecView.setHasFixedSize(true)
        val simpleAdapter = SimpleTaskAdapter()
        mainViewModel.getLocalList(DataList(id = mainViewModel.getCurrentListID()!!))

        mainViewModel.singleListLiveData.observe(viewLifecycleOwner, Observer {
            if(it?.tasks != null && it?.id == mainViewModel.getCurrentListID())
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
                simpleAdapter.setOnItemLongClickListener(object: SimpleTaskAdapter.onItemLongClickListener{
                    @SuppressLint("UseCompatLoadingForDrawables","ResourceType")
                    override fun onItemLongClicked(position: Int,id: String?,name: String?)
                    {
                        super.onItemLongClicked(position,id,name)
                        toolbar.setNavigationIcon(R.drawable.ic_cancel)
                        toolbar.setNavigationIconTint(Color.parseColor("#FF8686"))
                        toolbar.setNavigationOnClickListener {
                            revokeDefaultMenu()
                            tasksRecView.getChildAt(position).background = null
                        }
                        toolbar.menu.clear()
                        toolbar.inflateMenu(R.menu.action_bar_list_delete_menu)
                        tasksRecView.getChildAt(position).background = activity?.getDrawable(R.color.beige)
                        selectedTask = Task(id = id, name = name)
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
        addTaskButton = view.findViewById(R.id.main_list_add_task_button)
        taskEditText = view.findViewById(R.id.main_list_add_task_editText)
        taskEditText.doOnTextChanged { text, start, before, count ->  addTaskButton.visibility = View.VISIBLE}
        taskEditText.doAfterTextChanged {
            //addTaskButton.visibility = View.VISIBLE
            addTaskButton.setOnClickListener{
                if(verifyName(taskEditText.text.toString()))
                {
                    val listId = mainViewModel.getCurrentListID()
                    mainViewModel.addTask(taskEditText.text.toString(), listId!!, null)
                    taskEditText.text.clear()
                    addTaskButton.visibility = View.GONE
                }
                else
                {
                    Toast.makeText(activity, "Error Input",Toast.LENGTH_SHORT).show()
                }
            }
        }




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

    private fun verifyName(name: String): Boolean
    {
        var checker = false
        if(name.isNotEmpty())
        {
            checker = true
        }
        return checker
    }

    private fun revokeDefaultMenu()
    {
        toolbar.menu.clear()
        toolbar.navigationIcon = activity?.getDrawable(R.drawable.ic_action_back_button)
        toolbar.setNavigationIconTint(Color.BLACK)
        val host: Int = R.id.main_activity_nav_host_fragment
        val destination: Int = R.id.mainFragment3
        toolbar.setNavigationOnClickListener {
            mainViewModel.setCurrentList(null, null)
            requireActivity().findNavController(host).popBackStack(destination,true)
            requireActivity().findNavController(host).navigate(destination)
        }
        toolbar.inflateMenu(R.menu.action_bar_list_menu)
    }
}