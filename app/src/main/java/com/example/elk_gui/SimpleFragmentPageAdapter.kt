package com.example.elk_gui

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

@SuppressLint("ClickableViewAccessibility")
class SimpleFragmentPagerAdapter(fa: FragmentActivity, var viewPager: ViewPager2) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        if (position == 0) {
            return Fragment3()
        } else if (position == 1){
            return Fragment1()
        } else if (position == 2){
            return Fragment2()
        } else {
            return AboutApp()
        }
    }
}