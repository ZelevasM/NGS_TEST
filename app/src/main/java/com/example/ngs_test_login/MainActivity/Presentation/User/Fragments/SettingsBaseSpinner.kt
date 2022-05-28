package com.example.ngs_test_login.MainActivity.Presentation.User.Fragments

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.ngs_test_login.MainActivity.Presentation.User.UserViewModel
import com.example.ngs_test_login.R

class SettingsBaseSpinner(private val spinner: Spinner,private val array: Array<String>,private val context: Context?)
{
    var counter:Int = 0
    fun assign(flag: String?, userViewModel: UserViewModel)
    {
        val itemArray: Array<String> = array
        val spinnerArrayAdapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_item, itemArray)
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerArrayAdapter
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(parent: AdapterView<*>?,view: View?,position: Int,id: Long)
            {
                if(counter !=0)
                {
                    val str = parent?.getItemAtPosition(position).toString()
                    when (flag)
                    {
                        //"lang" -> userViewModel.changeLanguage()
                        "homepage" -> userViewModel.changeHomepage(str)
                        "dateFormat" -> userViewModel.changeDateFormat()
                        "timeFormat" -> userViewModel.changeTimeFormat()
                    }
                    Toast.makeText(context,str,Toast.LENGTH_SHORT).show()
                }
                counter+=1
            }

            override fun onNothingSelected(parent: AdapterView<*>?)
            {
                Toast.makeText(context, "HomepageError", Toast.LENGTH_SHORT).show()
            }
        }
    }
}