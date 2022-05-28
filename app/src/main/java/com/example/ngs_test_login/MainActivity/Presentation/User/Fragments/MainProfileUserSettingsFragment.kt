package com.example.ngs_test_login.MainActivity.Presentation.User.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.ngs_test_login.MainActivity.Presentation.Main.MainViewModel
import com.example.ngs_test_login.MainActivity.Presentation.User.UserViewModel
import com.example.ngs_test_login.R

class MainProfileUserSettingsFragment: Fragment()
{
    private val mainViewModel: MainViewModel by activityViewModels()
    private val userViewModel: UserViewModel by activityViewModels()

    private lateinit var userIcon: ImageView
    private lateinit var userName: TextView
    private lateinit var userEmail: TextView
    private lateinit var userNameEditText: EditText
    private lateinit var userEmailEditText: EditText
    private lateinit var userNameButton: Button
    private lateinit var userEmailButton: Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_profile_user_settings, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
    }

    //TODO GAVNO CODE
    private fun Init(view: View)
    {
        userName = view.findViewById(R.id.profile_user_info_name)
        userEmail = view.findViewById(R.id.profile_user_info_email)
        userNameEditText = view.findViewById(R.id.profile_user_name_editText)
        userEmailEditText = view.findViewById(R.id.profile_user_email_editText)
        userNameButton = view.findViewById(R.id.profile_user_name_button)
        userEmailButton = view.findViewById(R.id.profile_user_email_button)
        userViewModel.userNameLiveData.observe(viewLifecycleOwner, Observer {
            userName.text = it
            userNameEditText.text.clear()
        })
        userViewModel.userEmailLiveData.observe(viewLifecycleOwner, Observer {
            userEmail.text = it
            userEmailEditText.text.clear()
        })
        userNameButton.setOnClickListener {
            if(userNameEditText.text.toString().isNotEmpty())
                userViewModel.changeName(userNameEditText.text.toString())
            else
                Toast.makeText(context, "Enter Correctly!", Toast.LENGTH_SHORT).show()
        }
        userEmailButton.setOnClickListener {
            if(userEmailEditText.text.toString().isNotEmpty())
                userViewModel.changeEmail(userEmailEditText.text.toString())
            else
                Toast.makeText(context, "Enter Correctly!", Toast.LENGTH_SHORT).show()
        }

    }
}