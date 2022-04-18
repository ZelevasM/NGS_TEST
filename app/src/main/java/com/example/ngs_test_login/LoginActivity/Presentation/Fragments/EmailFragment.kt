package com.example.ngs_test_login.LoginActivity.Presentation.Fragments;

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ngs_test_login.LoginActivity.Presentation.LoginViewModel
import com.example.ngs_test_login.R

/**
 * EmailFragment is a fragment used to operate over verification of an email,
 * right after clicking to the 'Continue With Email' button in LoginFragment
 */
class EmailFragment : Fragment()
{
    private lateinit var emailButton : Button
    private lateinit var emailEditText: EditText
    /// private lateinit variable toolbar is used to control ActionBar
    private lateinit var toolbar: Toolbar
    /// private variable loginViewModel takes the same ViewModel, that was created in LoginActivity
    private val loginViewModel: LoginViewModel by activityViewModels()
    /// private variable checker takes values incoming from ViewModel, to store them locally
    private var checker: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_email_ent, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)

        Init(view)

        /**
         * after clicking on the button, it is firstly checked whether correct input is inserted,
         * only if it is ok, it proceeds by sending inserted data to the server,
         * and if the server returns true, it proceeds by taking the user to the password fragment,
         * if the server returns false, it proceeds by taking the user to the SignIpFragment
         */
        emailButton.setOnClickListener(){
            val str : String = emailEditText.text.toString()
            val emailChecker = verifyEmail(str)
            if(emailChecker)
            {
                loginViewModel.emailCheck(str)
                Log.d("MyLog","CheckerEmail: $checker")
                if (checker)
                {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.login_container,PasswordFragment.newInstance())?.commit()
                    /// just a Toast, to show correctness of the input, that should be changed later
                    //TODO
                    Toast.makeText(activity,"email: $str",Toast.LENGTH_LONG).show()

                } else
                {
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.login_container,SignUpFragment.newInstance())?.commit()
                }
            }
            else
            {
                /// just a Toast, to show incorrectness of the input, that should be changed later
                // TODO
                Toast.makeText(activity,"email: Wrong",Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object
    {
        fun newInstance() = EmailFragment()
    }

    /**
     * private fun Init is used to initialize all the required views on the fragment's layout
     * @param view: View of the current fragment
     */
    private fun Init(view : View)
    {
        toolbar = view.findViewById(R.id.toolbar_email)
        /// toolbar holds back button, which gets the user back to the LoginFragment, when it is pressed
        toolbar.setNavigationOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.login_container,LoginFragment.newInstance())?.commit()
        }
        emailButton = view.findViewById(R.id.button_email_cont)
        emailEditText = view.findViewById(R.id.editText_email)
        /// loginViewModel observes boolean resultLive from ViewModel,
        /// to check it and assign value to local variable checker
        loginViewModel.resultLive.observe(this,{
            checker = it
        })
    }

    /**
     * private fun verifyEmail is used to check that input data is valid
     * @param str: String corresponding to the input email
     * @return boolean validator, which is true if data(str) is valid,
     * and false if data(str) is invalid
     */
    private fun verifyEmail(str: String): Boolean
    {
        var validator = false
        if(str.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(str).matches())
        {
            validator = true
        }
        return validator
    }
}
