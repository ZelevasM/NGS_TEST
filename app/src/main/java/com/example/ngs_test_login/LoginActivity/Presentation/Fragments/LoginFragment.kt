package com.example.ngs_test_login.LoginActivity.Presentation.Fragments

import android.os.Build
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsetsController
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.ngs_test_login.LoginActivity.Presentation.LoginViewModel
import com.example.ngs_test_login.R
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking


class LoginFragment : Fragment()
{
    private lateinit var emailButton : Button
    private lateinit var googleButton : Button
    private lateinit var appleButton : Button
    private lateinit var termsTextView : TextView
    private lateinit var fbButton : Button

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?) : View?
    {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?)
    {
        super.onViewCreated(view,savedInstanceState)
        Init(view)

        /**
         * after clicking on the button, it proceeds by taking the user to the EmailFragment
         */
        emailButton.setOnClickListener(){
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container,EmailFragment.newInstance())?.commit()
        }
    }

    companion object
    {
        fun newInstance() = LoginFragment()
    }

    /**
     * fun Init is used to initialize all the required views on the fragment's layout
     * @param view: View of the current fragment
     */
    fun Init(view : View)
    {
        emailButton = view.findViewById(R.id.button_email_cont)
        googleButton = view.findViewById(R.id.button_google_cont)
        appleButton = view.findViewById(R.id.button_fb_cont)
        fbButton = view.findViewById(R.id.button_apple_cont)
        termsTextView = view.findViewById(R.id.textView_terms)
        /// enabling the transition from the hyperlink
        termsTextView.movementMethod = LinkMovementMethod.getInstance()
    }

}