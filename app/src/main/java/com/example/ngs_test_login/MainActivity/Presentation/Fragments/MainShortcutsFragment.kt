package com.example.ngs_test_login.MainActivity.Presentation.Fragments

import android.os.Bundle
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
import com.example.ngs_test_login.MainActivity.Domain.Models.Shortcut
import com.example.ngs_test_login.MainActivity.Domain.Models.User
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.ShortcutAdapter
import com.example.ngs_test_login.MainActivity.Presentation.MainViewModel
import com.example.ngs_test_login.R

class MainShortcutsFragment: Fragment()
{
    private val shortcutViewModel: MainViewModel by activityViewModels()
    private lateinit var shortRecView: RecyclerView

    //TODO FIX
    private lateinit var nullIcon: ImageView
    private lateinit var nullText: TextView

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_main_shortcuts, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    //TODO GAVNO CODE
    private fun Init(view: View)
    {
        nullIcon = view.findViewById(R.id.shortcuts_imageView)
        nullText = view.findViewById(R.id.textView_shortcuts_warn)

        var shortcuts: ArrayList<Shortcut?>?
        var adaper: ShortcutAdapter

        shortRecView = view.findViewById(R.id.shortRecView)
        shortRecView.layoutManager = LinearLayoutManager(this.context)
        shortRecView.setHasFixedSize(true)
        shortcutViewModel.shortcutsLiveData.observe(viewLifecycleOwner, Observer {
            shortcuts = it
            adaper = ShortcutAdapter(shortcuts)
            shortRecView.adapter= adaper

            nullIcon.visibility = View.GONE
            nullText.visibility = View.GONE
        })
    }
}