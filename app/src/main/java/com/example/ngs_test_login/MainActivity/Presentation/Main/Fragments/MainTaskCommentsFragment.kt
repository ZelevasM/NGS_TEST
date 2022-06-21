package com.example.ngs_test_login.MainActivity.Presentation.Main.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.R

class MainTaskCommentsFragment: Fragment()
{
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_main_task_comments,container,false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    //TODO GAVNO CODE
    private fun Init(view: View)
    {
        mainViewModel.addTaskMessage("62a1a832c7c8e80568614d36", "AzaSE4A2TWFoBejIxzKooWI=",
            "MTY1NDc2MTYyNDUxMV82MjYwZjg0ZTVkYjVlNTA1ZmFjY2VjYjI=", "NEW INFO", null, null)
    }
}