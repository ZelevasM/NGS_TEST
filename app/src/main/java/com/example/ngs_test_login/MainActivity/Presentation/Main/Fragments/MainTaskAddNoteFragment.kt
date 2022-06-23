package com.example.ngs_test_login.MainActivity.Presentation.Main.Fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel

import com.example.ngs_test_login.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar

class MainTaskAddNoteFragment: Fragment()
{
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var toolbar: MaterialToolbar
    private lateinit var appBarLayout: AppBarLayout
    private lateinit var noteInput: EditText
    private var INPUT_FLAG: Boolean = false

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_main_task_note,container,false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    //TODO GAVNO CODE
    private fun Init(view: View)
    {
        appBarLayout = view.findViewById(R.id.main_task_note_toolbar_layout)
        toolbar = view.findViewById(R.id.main_task_note_toolbar)
        toolbar.isTitleCentered = true
        toolbar.title = "Notes"
        toolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_mainTaskAddNoteFragment_to_mainTaskFragment)
        }
        noteInput = view.findViewById(R.id.main_task_note_input)

        mainViewModel.getLocalTask()
        mainViewModel.singleTaskLiveData.observe(viewLifecycleOwner, Observer {
            if(it?.notes != null && it.id == mainViewModel.getCurrentTaskID())
            {
                Log.d("MyLog", "task live")
                val notes = it.notes
                noteInput.setText(notes)
                noteInput.setSelection(noteInput.length())
            }
        })

        toolbar.setOnMenuItemClickListener {
            when(it.itemId)
            {
                R.id.action_done -> {
                    if(verifyNote(noteInput.text.toString()))
                    {
                        mainViewModel.noteTask(id = mainViewModel.getCurrentTaskID()!!, projectId = mainViewModel.getCurrentListID()!!, notes = noteInput.text.toString())
                    }
                    else
                    {
                        Toast.makeText(activity, "Error Input",Toast.LENGTH_SHORT).show()
                    }
                }
            }
            true
        }
    }

    private fun verifyNote(note: String): Boolean
    {
        var checker = false
        if(note.isNotEmpty())
        {
            checker = true
        }
        return checker
    }
}