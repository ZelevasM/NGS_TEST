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
 * SignUpFragment is a fragment used to operate over verification of a registration of a new user,
 * right after clicking to the 'Continue With Email' button in EmailFragment,
 * when the user is not found in the database
 */
class SignUpFragment : Fragment()
{
    private lateinit var submitButton : Button
    private lateinit var nameEditText : EditText
    private lateinit var passEditText : EditText
    private lateinit var passConfEditText : EditText
    private lateinit var signUpTextView: TextView
    /// private lateinit variable toolbar is used to control ActionBar
    private lateinit var toolbar: Toolbar
    /// private variable loginViewModel takes the same ViewModel, that was created in LoginActivity
    private val loginViewModel: LoginViewModel by activityViewModels()
    /// private variable checker takes values incoming from ViewModel, to store them locally
    private var checker: Boolean = false

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_email_signup, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)

        /**
         * after clicking on the button, it is firstly checked whether correct input is inserted,
         * only if it is ok, it proceeds by sending inserted data to the server,
         * and if  the server returns true, it proceeds by taking the user to the next fragment,
         * if the server returns false, it proceeds by waiting what the user does next,
         * enters data again, or anything else
         */
        submitButton.setOnClickListener(){
            val name: String = nameEditText.text.toString()
            val pass: String = passEditText.text.toString()
            val passConf: String = passConfEditText.text.toString()
            val userChecker = verifyUser(name, pass, passConf)

            if(userChecker)
            {
                loginViewModel.emailSignUp(name,pass)
                Log.d("MyLog","CheckerEmail: $checker")
                if (checker)
                {
                    /// just a Toast, to show correctness of the input, that should be changed later
                    //TODO
                    Toast.makeText(activity,"Created: $name",Toast.LENGTH_LONG).show()
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.login_container,LoginFragment.newInstance())?.commit()
                } else
                {
                    /// just a Toast, to show incorrectness of the input, that should be changed later
                    //TODO
                    Toast.makeText(activity,"ERROR!",Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                /// just a Toast, to show incorrectness of the input, that should be changed later
                //TODO
                Toast.makeText(activity,"GIVE NORMAL!",Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object
    {
        fun newInstance() = SignUpFragment()
    }

    /**
     * private fun Init is used to initialize all the required views on the fragment's layout
     * @param view: View of the current fragment
     */
    @SuppressLint("SetTextI18n")
    fun Init(view : View)
    {
        submitButton = view.findViewById(R.id.button_sign_up)
        nameEditText = view.findViewById(R.id.editTextTextPersonName)
        passEditText = view.findViewById(R.id.editTextTextPassword)
        passConfEditText = view.findViewById(R.id.editTextTextPassword_Confirm)
        signUpTextView = view.findViewById(R.id.textView_sample_email_signUp)
        signUpTextView.text = "For ${loginViewModel.userFromLogin.e}"
        toolbar = view.findViewById(R.id.toolbar_sign_up)
        /// toolbar holds back button, which gets the user back to the LoginFragment, when it is pressed
        toolbar.setNavigationOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.login_container,LoginFragment.newInstance())?.commit()
        }
        /// loginViewModel observes boolean resultLive from ViewModel,
        /// to check it and assign value to local variable checker
        loginViewModel.resultLive.observe(this,{
            checker = it
        })
    }

    /**
     * private fun verifyUser is used to check that input data is valid
     * @param name: String corresponding to the input name
     * @param pass: String corresponding to the input password
     * @param passConf: String corresponding to the input password for confirmation
     * @return boolean validator, which is true if data(name, pass, passConf) is valid,
     * and false if data(name, pass, passConf) is invalid
     */
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