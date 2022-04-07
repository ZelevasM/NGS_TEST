package com.example.ngs_test_login.LoginActivity.Presentation.Fragments;

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.*
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.ngs_test_login.LoginActivity.Data.Web.AsyncGet
import com.example.ngs_test_login.LoginActivity.Domain.Models.User
import com.example.ngs_test_login.LoginActivity.Presentation.LoginViewModel
import com.example.ngs_test_login.R

class EmailFragment : Fragment()
{
    private lateinit var emailButton : Button
    private lateinit var emailEditText: EditText
    private lateinit var toolbar: Toolbar
    private val loginViewModel: LoginViewModel by activityViewModels()
    private var checker: Boolean = false




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_email_ent, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)

        Init(view)
        emailButton.setOnClickListener(){
            //TODO validation
            val str : String = emailEditText.text.toString()
            val emailChecker = verifyEmail(str)
            //TODO validation more
            if(emailChecker)
            {
                loginViewModel.emailCheck(str)
                Log.d("MyLog","CheckerEmail: $checker")
                if (checker)
                {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.container,PasswordFragment.newInstance())?.commit()
                    Toast.makeText(activity,"email: $str",Toast.LENGTH_LONG).show()

                } else
                {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.container,SignUpFragment.newInstance())?.commit()
                }
            }
            else
            {
                Toast.makeText(activity,"email: Wrong",Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object
    {
        fun newInstance() = EmailFragment()
    }

    fun Init(view : View)
    {
        toolbar = view.findViewById(R.id.toolbar_email)
        toolbar.setNavigationOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container,LoginFragment.newInstance())?.commit()
        }
        emailButton = view.findViewById(R.id.button_email_cont)
        emailEditText = view.findViewById(R.id.editText_email)
        loginViewModel.resultLive.observe(this,{
            checker = it
        })
    }

    fun verifyEmail(str: String): Boolean
    {
        var validator = false
        if(str.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(str).matches())
        {
            validator = true
        }
        return validator
    }
}
