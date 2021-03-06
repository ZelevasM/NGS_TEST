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
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.DataListAdapter
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.R

class MainListsFragment: Fragment()
{
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var listRecView: RecyclerView

    //TODO FIX
    private lateinit var nullIcon: ImageView
    private lateinit var nullText: TextView

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_main_lists, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    //TODO GAVNO CODE
    private fun Init(view: View)
    {
        nullIcon = view.findViewById(R.id.lists_imageView)
        nullText = view.findViewById(R.id.textView_lists_warn)
        val adapter: DataListAdapter = DataListAdapter()
        listRecView = view.findViewById(R.id.listRecView)
        listRecView.layoutManager = LinearLayoutManager(this.context)
        listRecView.setHasFixedSize(true)
        mainViewModel.listsLiveData.observe(viewLifecycleOwner, Observer {
            adapter.lists = it
            listRecView.adapter = adapter
            adapter.setOnItemClickListener(object: DataListAdapter.onItemClickListener{
                override fun onItemClicked(position: Int, id: String?, name: String?)
                {
                    super.onItemClicked(position, id, name)
                    Toast.makeText(activity,"$position + $id" ,Toast.LENGTH_SHORT).show()
                    mainViewModel.setCurrentList(id = id, name = name)
                    val host: Int = R.id.main_activity_nav_host_fragment
                    val destination: Int = R.id.mainListHostFragment
                    requireActivity().findNavController(host).navigate(destination)

                }
            })
            adapter.setOnItemLongClickListener(object: DataListAdapter.onItemLongClickListener{
                override fun onItemLongClicked(position: Int,id: String?)
                {
                    super.onItemLongClicked(position,id)
                    Toast.makeText(activity,"$position + $id" ,Toast.LENGTH_SHORT).show()
                }
            })
            nullIcon.visibility = View.GONE
            nullText.visibility = View.GONE
        })
    }
}
