package com.example.ngs_test_login.MainActivity.Presentation.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngs_test_login.MainActivity.Domain.Models.DataList
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.DataListAdapter
import com.example.ngs_test_login.MainActivity.Presentation.MainViewModel
import com.example.ngs_test_login.R

class MainListsFragment: Fragment()
{
    private val listViewModel: MainViewModel by activityViewModels()
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


        var lists: ArrayList<DataList?>?
        var adapter: DataListAdapter
        listRecView = view.findViewById(R.id.listRecView)
        listRecView.layoutManager = LinearLayoutManager(this.context)
        listRecView.setHasFixedSize(true)
        listViewModel.listsLiveData.observe(viewLifecycleOwner, Observer {
            lists = it
            adapter = DataListAdapter(lists)
            listRecView.adapter = adapter


            nullIcon.visibility = View.GONE
            nullText.visibility = View.GONE
        })

    }
}
