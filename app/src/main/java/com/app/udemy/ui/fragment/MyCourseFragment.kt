package com.app.udemy.ui.fragment


import android.view.LayoutInflater
import android.view.ViewGroup
import com.app.udemy.databinding.FragmentMyCourseBinding
import com.app.udemy.model.ItemMyCourseEmpty
import com.app.udemy.ui.adapter.MyCourseEmptyAdapter
import com.app.udemy.ui.adapter.ViewPagerAdapter
import com.app.udemy.ui.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator


class MyCourseFragment : BaseFragment<FragmentMyCourseBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMyCourseBinding
        get() = FragmentMyCourseBinding::inflate

    private lateinit var adapter: MyCourseEmptyAdapter

    val courseCategoryList = listOf(
        ItemMyCourseEmpty("Development"),
        ItemMyCourseEmpty("Business"),
        ItemMyCourseEmpty("Finance & Accounting"),
        ItemMyCourseEmpty("IT & Software"),
        ItemMyCourseEmpty("Office Productivity"),
        ItemMyCourseEmpty("Personal Development"),
        ItemMyCourseEmpty("Design"),
        ItemMyCourseEmpty("Marketing"),
        ItemMyCourseEmpty("Lifestyle"),
        ItemMyCourseEmpty("Photography & Video"),
        ItemMyCourseEmpty("Health & Fitness"),
        ItemMyCourseEmpty("Music"),
        ItemMyCourseEmpty("Teaching & Academics")
    )

    override fun setup() {

        binding.viewPager.adapter = ViewPagerAdapter(requireActivity())

        TabLayoutMediator(binding.tabLayout , binding.viewPager){tab , position ->

            tab.text = when(position){

                0 -> "Completed"
                1 -> "Ongoing"
                else -> ""
            }
        }.attach()

        adapter = MyCourseEmptyAdapter(courseCategoryList)
        binding.rvCourseField.adapter = adapter
    }
}