package com.example.ngs_test_login.MainActivity.Presentation.Main.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngs_test_login.MainActivity.Domain.Main.Models.ListsModels.TaskMessage
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.MessageAdapter
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.R

class MainTaskCommentsFragment: Fragment()
{
    val userId = "62a1a832c7c8e80568614d36"

    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var messageRecView: RecyclerView
    private lateinit var messageInput: EditText
    private lateinit var sendMessageButton: ImageButton

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
        messageInput = view.findViewById(R.id.main_task_comments_message_editText)
        sendMessageButton = view.findViewById(R.id.main_task_comments_send)
        messageRecView = view.findViewById(R.id.main_task_comments_message_recView)
        val layoutManager = LinearLayoutManager(this.context).apply {
            stackFromEnd = true
        }
        messageRecView.layoutManager = layoutManager
        messageRecView.setHasFixedSize(true)
        val adapter = MessageAdapter()
        mainViewModel.getLocalTask()

//        mainViewModel.singleListLiveData.observe(viewLifecycleOwner, Observer {
//            var checker: Boolean = false
//            if(it?.tasks != null)
//            {
//                //TODO Save for future uses
//            }
//        })

       invokeDefaultSendButton()

        mainViewModel.singleTaskLiveData.observe(viewLifecycleOwner, Observer {
            if(it?.messages != null && it.id == mainViewModel.getCurrentTaskID())
            {
                val messages: ArrayList<TaskMessage?>? = it.messages
                adapter.messages = messages
                messageRecView.adapter = adapter
                adapter.setOnItemClickListener(object: MessageAdapter.onItemClickListenerMessage{
                    override fun onItemClicked(position: Int,id: String?,userId: String?,message: String?)
                    {
                        super.onItemClicked(position,id,userId, message)
                        Log.d("MyLog","Pressed")
//                        val popupMenu = PopupMenu(activity, messageRecView.findViewHolderForAdapterPosition(position)?.
//                        itemView?.findViewById(R.id.message_simple_item_container))
//
//                        if(userId == this@MainTaskCommentsFragment.userId)
//                            popupMenu.menuInflater.inflate(R.menu.message_popup_menu, popupMenu.menu)
//                        else
//                            popupMenu.menuInflater.inflate(R.menu.message_popup_menu, popupMenu.menu)
//
//                        popupMenu.setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener{
//                            override fun onMenuItemClick(item: MenuItem?): Boolean
//                            {
//                                when(item?.itemId)
//                                {
//                                    R.id.message_copy -> {
//
//                                    }
//
//                                    R.id.message_edit -> {
//                                        messageInput.setText(message)
//                                        sendMessageButton.setOnClickListener{
//                                            val message = messageInput.text.toString()
//                                            if(verifyMessage(message))
//                                            {
//                                                val currentTaskId = mainViewModel.getCurrentTaskID()
//                                                val currentListId = mainViewModel.getCurrentListID()
//                                                mainViewModel.renameTaskMessage(id, taskId = currentTaskId, listId = currentListId, message = message)
//                                                messageInput.text.clear()
//                                                invokeDefaultSendButton()
//                                            }
//                                            else
//                                            {
//                                                Toast.makeText(requireContext(), "Invalid Input", Toast.LENGTH_SHORT).show()
//                                            }
//                                        }
//                                    }
//
//                                    R.id.message_delete -> {}
//                                }
//                                return true
//                            }
//                        })
                        //popupMenu.show()
                    }
                })
            }
        })
    }

    private fun verifyMessage(message: String): Boolean
    {
        var checker = false
        if(message.isNotEmpty())
        {
            checker = true
        }
        return checker
    }

    override fun onDestroy()
    {
        mainViewModel.setCurrentList(null, null)
        mainViewModel.setCurrentTask(null, null)
        super.onDestroy()
    }

    fun invokeDefaultSendButton()
    {
        sendMessageButton.setOnClickListener{
            val message = messageInput.text.toString()
            if(verifyMessage(message))
            {
                val currentTaskId = mainViewModel.getCurrentTaskID()
                val currentListId = mainViewModel.getCurrentListID()
                mainViewModel.addTaskMessage(userId = userId, taskId = currentTaskId, listId = currentListId, message = message, null, null)
                messageInput.text.clear()
            }
            else
            {
                Toast.makeText(requireContext(), "Invalid Input", Toast.LENGTH_SHORT).show()
            }
        }
    }
}