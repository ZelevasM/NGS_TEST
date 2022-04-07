package com.example.ngs_test_login.LoginActivity.Presentation

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.ngs_test_login.LoginActivity.Data.Web.AsyncGet
import com.example.ngs_test_login.LoginActivity.Presentation.Fragments.EmailFragment
import com.example.ngs_test_login.LoginActivity.Presentation.Fragments.LoginFragment
import com.example.ngs_test_login.R
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class LoginActivity : AppCompatActivity()
{
    //TODO EXP
    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportFragmentManager.beginTransaction().replace(R.id.container,LoginFragment.newInstance()).commit()
    }


    //TODO EXP


}