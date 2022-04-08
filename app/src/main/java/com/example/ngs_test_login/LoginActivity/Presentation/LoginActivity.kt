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

/**
 * @author Akbarbek Rakhmatullaev
 * @author for New Generation Solutions (Tashkent, Uzbekistan, year: 2022)
 * @author ALL RIGHTS ARE RESERVED
 */

/**
 * class LoginActivity provides a base layer for all other fragments
 * inside of LoginActivity
*/
class LoginActivity : AppCompatActivity()
{
    /**
     * private variable loginViewModel is required to contain one ViewModel,
     * excluding necessity to create ViewModel in each fragment,
     * so all fragments share the same ViewModel
     */
    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /// starting LoginFragment, inside of R.id.container in LoginActivity's layout
        supportFragmentManager.beginTransaction().replace(R.id.container,LoginFragment.newInstance()).commit()
    }
}