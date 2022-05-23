package com.example.ngs_test_login.MainActivity.Presentation.Main.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.R

class MainAddChatFragment: Fragment()
{
    private val mainAddChatViewModel: MainViewModel by activityViewModels()
    private lateinit var chatName: EditText
    private lateinit var addMemberButton: Button
    private lateinit var createChat: Button
    private lateinit var cancelButton: Button

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_main_add_chat, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    private fun Init(view: View)
    {
        chatName = view.findViewById(R.id.main_add_chat_name)

        addMemberButton = view.findViewById(R.id.main_add_chat_add_button)
        createChat = view.findViewById(R.id.main_add_chat_create_button)
        cancelButton = view.findViewById(R.id.main_add_chat_cancel_button)

        val host: Int = R.id.main_activity_nav_host_fragment
        val destination: Int = R.id.mainFragment3

        createChat.setOnClickListener {
            val name: String = chatName.text.toString()
            val nameChecker: Boolean = verifyName(name)
            if(nameChecker)
            {
                mainAddChatViewModel.addChat(name)
                Toast.makeText(activity,"Added: $name",Toast.LENGTH_LONG).show()
                requireActivity().findNavController(host).popBackStack(destination, true)
                requireActivity().findNavController(host).navigate(destination)
            }
            else
            {
                Toast.makeText(activity,"Wrong",Toast.LENGTH_LONG).show()
            }
        }

        cancelButton.setOnClickListener {
            requireActivity().findNavController(host).popBackStack(destination, true)
            requireActivity().findNavController(host).navigate(destination)
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
}