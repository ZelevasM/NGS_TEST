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
import com.example.ngs_test_login.LoginActivity.Presentation.LoginViewModel
import com.example.ngs_test_login.R

class SignUpFragment : Fragment()
{
    private lateinit var submitButton : Button
    private lateinit var nameEditText : EditText
    private lateinit var passEditText : EditText
    private lateinit var passConfEditText : EditText
    private lateinit var signUpTextView: TextView
    private lateinit var toolbar: Toolbar
    private val loginViewModel: LoginViewModel by activityViewModels()
    private var checker: Boolean = false

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_email_signup, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)
        submitButton.setOnClickListener(){
            //TODO validation
            val name: String = nameEditText.text.toString()
            val pass: String = passEditText.text.toString()
            val passConf: String = passConfEditText.text.toString()

            //TODO validation more
            val userChecker = verifyUser(name, pass, passConf)
            if(userChecker)
            {
                loginViewModel.emailSignUp(name,pass)
                Log.d("MyLog","CheckerEmail: $checker")
                if (checker)
                {
                    Toast.makeText(activity,"Created: $name",Toast.LENGTH_LONG).show()
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.container,LoginFragment.newInstance())?.commit()
                } else
                {
                    Toast.makeText(activity,"ERROR!",Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(activity,"GIVE NORMAL!",Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object
    {
        fun newInstance() = SignUpFragment()
    }

    @SuppressLint("SetTextI18n")
    fun Init(view : View)
    {
        submitButton = view.findViewById(R.id.button_sign_up)
        nameEditText = view.findViewById(R.id.editTextTextPersonName)
        passEditText = view.findViewById(R.id.editTextTextPassword)
        passConfEditText = view.findViewById(R.id.editTextTextPassword_Confirm)
        signUpTextView = view.findViewById(R.id.textView_sample_email_signUp)
        signUpTextView.text = "For ${loginViewModel.user.e}"
        toolbar = view.findViewById(R.id.toolbar_sign_up)
        toolbar.setNavigationOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container,LoginFragment.newInstance())?.commit()
        }
        loginViewModel.resultLive.observe(this,{
            checker = it
        })
    }

    fun verifyUser(name: String, pass: String, passConf: String): Boolean
    {
        var validator = false
        if(name.isNotEmpty() && pass.isNotEmpty() && passConf.isNotEmpty() && pass == passConf)
        {
            validator = true
        }
        return validator
    }

}