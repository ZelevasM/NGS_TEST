package com.example.ngs_test_login.MainActivity.Presentation.Adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TaskViewPagerAdapter(private val fragments: List<Fragment>,
                           private val fragment: Fragment): FragmentStateAdapter(fragment)
{
    override fun getItemCount(): Int
    {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment
    {
        return fragments[position]
    }
}