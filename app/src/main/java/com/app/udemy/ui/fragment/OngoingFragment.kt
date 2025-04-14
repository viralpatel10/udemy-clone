package com.app.udemy.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.udemy.R
import com.app.udemy.databinding.FragmentOngoingfragmentBinding
import com.app.udemy.model.OngoingCourseItem
import com.app.udemy.ui.adapter.OngoingCourseAdapter
import com.app.udemy.ui.base.BaseFragment


class OngoingFragment : BaseFragment<FragmentOngoingfragmentBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentOngoingfragmentBinding
        get() = FragmentOngoingfragmentBinding::inflate

    private lateinit var adapter: OngoingCourseAdapter
    override fun setup() {

        binding.rvMyOngoingCourse.layoutManager = LinearLayoutManager(requireContext())

        val sampleCourses = listOf(
            OngoingCourseItem(R.drawable.image_my_course, "Graphic Design", "Advertisement Design", "2 Hrs 36 mins", 15, 30),
            OngoingCourseItem(R.drawable.image_my_course, "Graphic Design", "Advertisement Design", "2 Hrs 36 mins", 15, 30),
        )

        adapter = OngoingCourseAdapter(sampleCourses)
        binding.rvMyOngoingCourse.adapter = adapter

    }

}