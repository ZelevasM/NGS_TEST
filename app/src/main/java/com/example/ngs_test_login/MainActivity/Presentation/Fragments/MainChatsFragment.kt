package com.example.ngs_test_login.MainActivity.Presentation.Fragments

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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngs_test_login.MainActivity.Domain.Models.Chat
import com.example.ngs_test_login.MainActivity.Presentation.Adapters.ChatAdapter
import com.example.ngs_test_login.MainActivity.Presentation.MainViewModel
import com.example.ngs_test_login.R

class MainChatsFragment: Fragment()
{
    private val chatViewModel: MainViewModel by activityViewModels()
    private lateinit var chatRecView: RecyclerView

    //TODO FIX
    private lateinit var nullIcon: ImageView
    private lateinit var nullText: TextView

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_main_chats, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    //TODO GAVNO CODE
    private fun Init(view: View)
    {
        nullIcon = view.findViewById(R.id.chats_imageView)
        nullText = view.findViewById(R.id.textView_chats_warn)


        var chats: ArrayList<Chat?>?
        var adapter: ChatAdapter
        chatRecView = view.findViewById(R.id.chatRecView)
        chatRecView.layoutManager = LinearLayoutManager(this.context)
        chatRecView.setHasFixedSize(true)
        chatViewModel.chatsLiveData.observe(viewLifecycleOwner, Observer {
            chats = it
            adapter = ChatAdapter(chats)
            chatRecView.adapter = adapter
            adapter.setOnItemClickListener(object: ChatAdapter.onItemClickListener{
                override fun onItemClicked(position: Int,id: String?)
                {
                    super.onItemClicked(position,id)
                    Toast.makeText(activity,"$position + $id" ,Toast.LENGTH_SHORT).show()
                }
            })

            nullIcon.visibility = View.GONE
            nullText.visibility = View.GONE
        })
    }
}