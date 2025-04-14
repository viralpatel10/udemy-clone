package com.app.udemy.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.app.udemy.ui.fragment.CompletedFragment
import com.app.udemy.ui.fragment.OngoingFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity):
    FragmentStateAdapter(fragmentActivity){

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {

            0 -> CompletedFragment()
            1 -> OngoingFragment()
            else -> CompletedFragment()
        }
    }
}