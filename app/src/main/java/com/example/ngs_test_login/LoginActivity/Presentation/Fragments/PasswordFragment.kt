package com.example.ngs_test_login.LoginActivity.Presentation.Fragments

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsetsController
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.ngs_test_login.LoginActivity.Domain.Models.User
import com.example.ngs_test_login.LoginActivity.Presentation.LoginViewModel
import com.example.ngs_test_login.R

class PasswordFragment : Fragment()
{
    private lateinit var submitButton : Button
    private lateinit var passEditText: EditText
    private lateinit var passTextView: TextView
    private lateinit var toolbar: Toolbar
    private val loginViewModel: LoginViewModel by activityViewModels()
    private var checker: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_email_pass, container, false)
    }


    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
        submitButton.setOnClickListener(){
            val str: String = passEditText.text.toString()
            val passChecker = verifyPass(str)
            if(passChecker)
            {
                loginViewModel.emailPassCheck(str)
                if (checker)
                {
                    Toast.makeText(activity,"password: $str",Toast.LENGTH_LONG).show()
                    Log.d("MyLog","CheckerPass: $checker")
                } else
                {
                    Toast.makeText(activity,"password: Wrong",Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(activity,"password: Wrong",Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object
    {
        fun newInstance() = PasswordFragment()
    }

    @SuppressLint("SetTextI18n")
    fun Init(view: View)
    {
        submitButton = view.findViewById(R.id.button_email_submit)
        passEditText = view.findViewById(R.id.editText_password)
        passTextView = view.findViewById(R.id.textView_sample_email)
        passTextView.text = "For ${loginViewModel.user.e}"
        toolbar = view.findViewById(R.id.toolbar_pass)
        toolbar.setNavigationOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container,EmailFragment.newInstance())?.commit()
        }
        loginViewModel.resultLive.observe(this,{
            checker = it
        })
    }
    fun verifyPass(str: String): Boolean
    {
        var validator = false
        if(str.isNotEmpty())
        {
            validator = true
        }
        return validator
    }
}