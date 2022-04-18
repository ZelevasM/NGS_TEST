package com.example.ngs_test_login.LoginActivity.Presentation.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ngs_test_login.LoginActivity.Presentation.LoginViewModel
import com.example.ngs_test_login.R

/**
 * PasswordFragment is a fragment used to operate over verification of a password,
 * right after clicking to the 'Continue With Email' button in EmailFragment
 */
class PasswordFragment : Fragment()
{
    private lateinit var submitButton : Button
    private lateinit var passEditText: EditText
    private lateinit var passTextView: TextView
    /// private lateinit variable toolbar is used to control ActionBar
    private lateinit var toolbar: Toolbar
    /// private variable loginViewModel takes the same ViewModel, that was created in LoginActivity
    private val loginViewModel: LoginViewModel by activityViewModels()
    /// private variable checker takes values incoming from ViewModel, to store them locally
    private var checker: Boolean = false

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_email_pass, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)

        /**
         * after clicking on the button, it is firstly checked whether correct input is inserted,
         * only if it is ok, it proceeds by sending inserted data to the server,
         * and if the server returns true, it proceeds by taking the user to the next fragment,
         * if the server returns false, it proceeds by waiting what the user does next,
         * enters password again, or anything else
         */
        submitButton.setOnClickListener(){
            val str: String = passEditText.text.toString()
            val passChecker = verifyPass(str)
            if(passChecker)
            {
                loginViewModel.emailPassCheck(str)
                if (checker)
                {
                    /// just a Toast, to show correctness of the input, that should be changed later
                    //TODO
                    Toast.makeText(activity,"password: $str",Toast.LENGTH_LONG).show()
                    Log.d("MyLog","CheckerPass: $checker")
                }
                else
                {
                    /// just a Toast, to show incorrectness of the input, that should be changed later
                    //TODO
                    Toast.makeText(activity,"password: Wrong",Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                /// just a Toast, to show incorrectness of the input, that should be changed later
                //TODO
                Toast.makeText(activity,"password: Wrong",Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object
    {
        fun newInstance() = PasswordFragment()
    }

    /**
     * private fun Init is used to initialize all the required views on the fragment's layout
     * @param view: View of the current fragment
     */
    @SuppressLint("SetTextI18n")
    private fun Init(view: View)
    {
        submitButton = view.findViewById(R.id.button_email_submit)
        passEditText = view.findViewById(R.id.editText_password)
        passTextView = view.findViewById(R.id.textView_sample_email)
        passTextView.text = "For ${loginViewModel.user.e}"
        toolbar = view.findViewById(R.id.toolbar_pass)
        /// toolbar holds back button, which gets the user back to the EmailFragment, when it is pressed
        toolbar.setNavigationOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.login_container,EmailFragment.newInstance())?.commit()
        }
        /// loginViewModel observes boolean resultLive from ViewModel,
        /// to check it and assign value to local variable checker
        loginViewModel.resultLive.observe(this,{
            checker = it
        })
    }

    /**
     * private fun verifyPass is used to check that input data is valid
     * @param str: String corresponding to the input email
     * @return boolean validator, which is true if data(str) is valid,
     * and false if data(str) is invalid
     */
    private fun verifyPass(str: String): Boolean
    {
        var validator = false
        if(str.isNotEmpty())
        {
            validator = true
        }
        return validator
    }
}